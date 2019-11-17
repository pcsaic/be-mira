package com.mira.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EventStatus {
    TODO("todo"),
    INPROGRESS("inProgress"),
    DONE("done"),
    BLOCK("block");

    private final String value;
}
