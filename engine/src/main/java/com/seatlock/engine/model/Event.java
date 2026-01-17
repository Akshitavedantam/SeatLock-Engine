package com.seatlock.engine.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;


    private String location;


    @Column(nullable = false, name = "event_date")
    private ZonedDateTime eventDate;
    @Column(nullable = false, name = "total_seats")
    private Integer totalSeats;
}