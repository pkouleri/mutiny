package com.mutiny;

import com.mutiny.events.EventConsumer;
import com.mutiny.events.listeners.EventListener;
import com.mutiny.events.listeners.ClientEventListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    final static String queueName = "mutiny.client.events.queue";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("mutiny.client.events.exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    EventConsumer receiver() {
        List<EventListener> listeners = new ArrayList<>();
        listeners.add(new ClientEventListener());
        return new EventConsumer(listeners);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(EventConsumer receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
