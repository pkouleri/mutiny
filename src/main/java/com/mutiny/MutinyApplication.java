package com.mutiny;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableMap;
import com.mutiny.events.EventConsumer;
import com.mutiny.events.listeners.ClientEventListener;
import com.mutiny.events.listeners.EventListener;

@SpringBootApplication
@EnableAutoConfiguration
public class MutinyApplication extends SpringBootServletInitializer {
	final static String CONFIG_NAME = "mutiny-application";

	final static String CLIENT_EVENTS_QUEUE_NAME = "mutiny.client.events.queue";

	public static void main(String[] args) {
		new SpringApplicationBuilder(MutinyApplication.class).properties(ImmutableMap.of("spring.config.name", CONFIG_NAME)).build().run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.properties(ImmutableMap.of("spring.config.name", CONFIG_NAME));
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		HttpClient httpClient = HttpClientBuilder.create()
				.setMaxConnTotal(40)
				.setMaxConnPerRoute(20)
				.build();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));

		return restTemplate;
	}

	@Bean
	public Queue queue() {
		return new Queue(CLIENT_EVENTS_QUEUE_NAME, false);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("mutiny.client.events.exchange");
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(CLIENT_EVENTS_QUEUE_NAME);
	}

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(CLIENT_EVENTS_QUEUE_NAME);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	public ClientEventListener clientEventListener(SimpMessagingTemplate simpMessagingTemplate) {
		return new ClientEventListener(simpMessagingTemplate);
	}

	@Bean
	public EventConsumer receiver(ClientEventListener clientEventListener) {
		List<EventListener> listeners = new ArrayList<>();
		listeners.add(clientEventListener);
		return new EventConsumer(listeners);
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(EventConsumer receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

}
