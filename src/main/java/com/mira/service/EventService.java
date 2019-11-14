package com.mira.service;

import com.mira.document.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents();

    Event getEvent(String id);
}
