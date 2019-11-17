package com.mira.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EventType {
    STORY("story"),
    TASK("task"),
    SPIKE("spike"),
    BUG("bug");

    private final String value;
}
