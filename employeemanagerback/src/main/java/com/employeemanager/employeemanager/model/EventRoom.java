package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EventRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    public EventRoom(){

    }
    public EventRoom(Event event, Room room){
        this.event=event;
        this.room=room;
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

    @Override
    public String toString() {
        return "EventRoom{" +
                "id=" + id +
                ", event=" + event +
                ", room=" + room +
                '}';
    }
}
