package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EventNote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    public EventNote() {

    }

    public EventNote(Event event, Note note) {
        this.event = event;
        this.note = note;
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

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "EventNote{" +
                "id=" + id +
                ", event=" + event +
                ", note=" + note +
                '}';
    }
}
