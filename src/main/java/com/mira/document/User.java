package com.mira.document;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class User {

    @Id
    @NonNull
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String mail;
    private UUID groupId;
}
