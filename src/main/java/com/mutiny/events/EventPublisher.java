package com.mutiny.events;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

	@Autowired
	ConnectionFactory connectionFactory;

	/**
	 * adds message to rabbitMQ, client events queue
	 */
	public void fireClientEvent(Event event) {
		try {
			byte[] messageBytes = event.getContent().getBytes("utf-8");

			MessageProperties messageProperties = new MessageProperties();
			messageProperties.setContentEncoding("utf-8");

			RabbitTemplate topicTemplate = new RabbitTemplate(getConnectionFactory());
			topicTemplate.send("mutiny.client.events.exchange", "mutiny.client.events.queue", new Message(messageBytes, messageProperties));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
}
