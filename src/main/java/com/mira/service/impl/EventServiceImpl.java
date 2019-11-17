package com.mira.service.impl;

import com.mira.document.Event;
import com.mira.document.EventStatus;
import com.mira.document.EventType;
import com.mira.repository.EventRepository;
import com.mira.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(String id) {
        return eventRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<Event> getAllEventsByStatus(EventStatus eventStatus) {
        return eventRepository.findAllByEventStatus(eventStatus);
    }

    @Override
    public List<Event> getAllEventsByType(EventType eventType) {
        return eventRepository.findAllByEventType(eventType);
    }
}
