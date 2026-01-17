package com.seatlock.engine.config;

import com.seatlock.engine.model.Event;
import com.seatlock.engine.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;

    public DataLoader(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        eventRepository.deleteAll();

        Event event1 = new Event();
        event1.setTitle("Arijit Singh Live - Soul India Tour");
        event1.setLocation("Gachibowli Indoor Stadium, Hyderabad");
        event1.setEventDate(ZonedDateTime.parse("2026-08-15T19:00:00+05:30"));
        event1.setTotalSeats(5000);
        eventRepository.save(event1);

        Event event2 = new Event();
        event2.setTitle("AI & ML Workshop @ T-Hub");
        event2.setLocation("T-Hub Phase 2, Raidurg");
        event2.setEventDate(ZonedDateTime.parse("2026-02-20T10:00:00+05:30"));
        event2.setTotalSeats(150);
        eventRepository.save(event2);

        System.out.println("Data Loaded Successfully!");
    }
}