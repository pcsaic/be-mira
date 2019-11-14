package com.mira.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class User {

    @Id
    private UUID id;
    private String name;
    private String surname;
    private String mail;
}
