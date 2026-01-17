package com.seatlock.engine.controller;

import com.seatlock.engine.model.Event;
import com.seatlock.engine.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public Event createEvent(@RequestBody Event event) {

        return eventService.createEvent(event);
    }
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}