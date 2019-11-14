package com.mira.repository;

import com.mira.document.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EventRepository extends MongoRepository<Event, UUID> {
}
