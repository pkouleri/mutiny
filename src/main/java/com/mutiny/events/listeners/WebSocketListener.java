package com.mutiny.events.listeners;

import com.mutiny.model.OutboundPost;
import com.mutiny.events.Event;
import com.mutiny.model.InboundPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;

@Controller
public class WebSocketListener implements EventListener {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/post")
    @SendTo("/topic/posts")
    public OutboundPost post(InboundPost message) throws Exception {
        Thread.sleep(1000);
        return new OutboundPost("New post, " + message.getContent() + "!");
    }

    // event from rabbitMQ
    @Override
    public void onEvent(Event event) {
        String message = getContent(event);
        try {
            messagingTemplate.convertAndSend("/topic/posts", message.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String getContent(Event event) {
        return "new post";
    }

    public SimpMessageSendingOperations getMessagingTemplate() {
        return messagingTemplate;
    }

    public void setMessagingTemplate(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
}
