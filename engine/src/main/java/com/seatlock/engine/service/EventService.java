package com.seatlock.engine.service;

import com.seatlock.engine.model.Event;
import com.seatlock.engine.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class  EventService {
 private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public Event createEvent(Event event) {

        return eventRepository.save(event);
    }
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}

