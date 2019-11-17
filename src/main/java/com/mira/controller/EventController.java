package com.mira.controller;

import com.mira.document.Event;
import com.mira.document.EventStatus;
import com.mira.document.EventType;
import com.mira.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/events")
public class EventController {

    private final EventService eventService;

    @GetMapping(value = "/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(value = "/{id}")
    public Event getEvent(@PathVariable String id) {
        return eventService.getEvent(id);
    }

    @GetMapping(value = "/{type}")
    public List<Event> getAllEventsByType(@PathVariable EventType eventType) {
        return eventService.getAllEventsByType(eventType);
    }

    @GetMapping(value = "/status")
    public List<Event> getAllEventsByStatus(@PathVariable EventStatus eventStatus) {
        return eventService.getAllEventsByStatus(eventStatus);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEvent(@PathVariable("id") UUID uuid){
         eventService.deleteEvent(uuid);
    }
}
