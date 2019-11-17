package com.mira.repository;

import com.mira.document.Event;
import com.mira.document.EventStatus;
import com.mira.document.EventType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends MongoRepository<Event, UUID> {

    List<Event> findAllByEventStatus(EventStatus eventStatus);

    List<Event> findAllByEventType(EventType eventType);
}
