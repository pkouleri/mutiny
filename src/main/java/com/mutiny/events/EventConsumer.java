package com.mutiny.events;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.mutiny.events.listeners.EventListener;

public class EventConsumer implements MessageListener {
    protected List<EventListener> listeners = new ArrayList<>();

    public EventConsumer(List<EventListener> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void onMessage(Message message) {
        try {
            String body = new String(message.getBody(), "utf-8");
            for (EventListener eventListener : listeners) {
                eventListener.onEvent(new Event(body));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
