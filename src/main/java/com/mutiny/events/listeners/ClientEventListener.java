package com.mutiny.events.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.mutiny.events.Event;


@Controller
public class ClientEventListener implements EventListener {

	private SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	public ClientEventListener(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}


	// event from rabbitMQ is sent to connected client(s) via websockets
	@Override
	public void onEvent(Event event) {
		simpMessagingTemplate.convertAndSend("/topic/posts", event.getContent());
	}

	public SimpMessagingTemplate getMessagingTemplate() {
		return simpMessagingTemplate;
	}

	public void setMessagingTemplate(SimpMessagingTemplate messagingTemplate) {
		this.simpMessagingTemplate = messagingTemplate;
	}
}
