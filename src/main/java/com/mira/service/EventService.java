package com.mira.service;

import com.mira.document.Event;
import com.mira.document.EventStatus;
import com.mira.document.EventType;

import java.util.List;
import java.util.UUID;

public interface EventService {

    List<Event> getAllEvents();

    Event getEvent(String id);

    List<Event> getAllEventsByStatus(EventStatus eventStatus);

    List<Event> getAllEventsByType(EventType eventType);

    Event createEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(UUID uuid);
}
