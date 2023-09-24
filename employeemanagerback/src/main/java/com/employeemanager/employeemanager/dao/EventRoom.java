package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "event_room")
public class EventRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    public EventRoom() {
    }

    public EventRoom(Long id, Event event, Room room) {
        this.id = id;
        this.event = event;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}