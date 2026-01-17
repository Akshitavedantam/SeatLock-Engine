package com.seatlock.engine.service;

import com.seatlock.engine.model.Booking;
import com.seatlock.engine.model.Event;
import com.seatlock.engine.repository.BookingRepository;
import com.seatlock.engine.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;

    public BookingService(BookingRepository bookingRepository, EventRepository eventRepository) {
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Booking bookTicket(Long eventId, String userEmail, int seatsToBook) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found!"));

        if (event.getTotalSeats() < seatsToBook) {
            throw new RuntimeException("SOLD OUT! Not enough seats available.");
        }

        event.setTotalSeats(event.getTotalSeats() - seatsToBook);
        eventRepository.save(event);

        Booking booking = new Booking();
        booking.setEventId(eventId);
        booking.setUserEmail(userEmail);
        booking.setSeatsBooked(seatsToBook);
        booking.setBookingTime(LocalDateTime.now());

        return bookingRepository.save(booking);
    }
}