package com.mutiny.persistence;

import com.mutiny.events.EventPublisher;
import com.mutiny.model.Post;
import com.mutiny.events.Event;
import org.springframework.beans.factory.annotation.Autowired;

public class PostRepository {
    @Autowired
    EventPublisher eventPublisher;

    public void save(Post post) {
        doClientEvent(new Event(post));
    }

    private void doClientEvent(Event event) {
        getEventPublisher().fireClientEvent(event);
    }

    public EventPublisher getEventPublisher() {
        return eventPublisher;
    }

    public void setEventPublisher(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
}
