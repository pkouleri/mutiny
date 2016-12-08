package com.mutiny.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.mutiny.events.Event;
import com.mutiny.events.EventPublisher;

public abstract class AbstractRepository {

	@Autowired
	EventPublisher eventPublisher;

	public void doClientEvent(Event event) {
		getEventPublisher().fireClientEvent(event);
	}

	public EventPublisher getEventPublisher() {
		return eventPublisher;
	}

	public void setEventPublisher(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
}
