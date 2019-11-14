package com.mira.controller;

import com.mira.document.Event;
import com.mira.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/events")
public class EventController {

    private final EventService eventService;

    @GetMapping(value = "/all")
    public List<Event> getAllEvent(){
        return eventService.getAllEvents();
    }

    @GetMapping(value = "/{id}")
    public Event getEvent(@PathVariable String id){
        return eventService.getEvent(id);
    }
}
