package com.mutiny.events.listeners;

import java.io.UnsupportedEncodingException;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.mutiny.events.Event;
import com.mutiny.model.Post;


@Controller
public class ClientEventListener implements EventListener {

	//@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	public ClientEventListener(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}

	@MessageMapping("/post")
	@SendTo("/topic/posts")
	public Post post(Post message) throws Exception {
		Thread.sleep(1000);
		return new Post("New post, " + message.getContent() + "!");
	}

	// event from rabbitMQ is sent to connected client(s) via websockets
	@Override
	public void onEvent(Event event) {
		String message = getContent(event);
		try {
			simpMessagingTemplate.convertAndSend("/topic/posts", message.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private String getContent(Event event) {
		return "new post";
	}

	public SimpMessagingTemplate getMessagingTemplate() {
		return simpMessagingTemplate;
	}

	public void setMessagingTemplate(SimpMessagingTemplate messagingTemplate) {
		this.simpMessagingTemplate = messagingTemplate;
	}
}
