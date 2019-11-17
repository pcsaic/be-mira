package com.mira.document;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Document
public class Event {

    @Id
    private UUID id;

    @NonNull
    private String title;

    @NonNull
    private ZonedDateTime startDate;

    @NonNull
    private ZonedDateTime updatedDate;

    @NonNull
    private UUID updatedPersonId;

    @NonNull
    private EventType eventType;

    @NonNull
    private EventStatus eventStatus;

    @NonNull
    private UUID ownerId;
    private String text;
    private Set<UUID> taskId;
    private Set<UUID> relatedPersonsIds;
}
