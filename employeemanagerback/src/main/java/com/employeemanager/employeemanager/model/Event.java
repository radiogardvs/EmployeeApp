package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;
    private EventType eventType;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
