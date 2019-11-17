package com.mira.service.impl;

import com.mira.document.Event;
import com.mira.document.EventStatus;
import com.mira.document.EventType;
import com.mira.repository.EventRepository;
import com.mira.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
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

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.findById(event.getId())
                .map(newEvent -> {
                            newEvent.setTitle(event.getTitle());
                            newEvent.setText(event.getText());
                            newEvent.setEventStatus(event.getEventStatus());
                            newEvent.setEventType(event.getEventType());
                            newEvent.setRelatedPersonsIds(event.getRelatedPersonsIds());
                            newEvent.setTaskId(event.getTaskId());
                            newEvent.setUpdatedDate(ZonedDateTime.now());
                            newEvent.setUpdatedPersonId(UUID.randomUUID()); /*hardcode!*/
                            return eventRepository.save(newEvent);
                        }
                ).orElse(eventRepository.save(event));
    }

    @Override
    public void deleteEvent(UUID uuid) {
        eventRepository.findById(uuid)
                .map(deletedEvent -> {
                    deletedEvent.setEventStatus(EventStatus.REMOVED);
                    return eventRepository.save(deletedEvent);
                });
    }
}
