package com.seatlock.engine.controller;

import com.seatlock.engine.model.Booking;
import com.seatlock.engine.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Map<String, Object> payload) {
        Long eventId = Long.valueOf(payload.get("eventId").toString());
        String userEmail = payload.get("userEmail").toString();
        int seats = Integer.parseInt(payload.get("seats").toString());

        return bookingService.bookTicket(eventId, userEmail, seats);
    }
}