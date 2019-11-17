package com.mira.service;

import com.mira.document.Event;
import com.mira.document.EventStatus;
import com.mira.document.EventType;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents();

    Event getEvent(String id);

    List<Event> getAllEventsByStatus(EventStatus eventStatus);

    List<Event> getAllEventsByType(EventType eventType);
}
