package com.mira.document;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Document
public class Event {

    @Id
    @NonNull
    private UUID id;

    @NonNull
    private String title;

    @NonNull
    private LocalDateTime startDate;

    @NonNull
    private LocalDateTime updatedDate;

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
