package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String eventType;
    @OneToMany(mappedBy = "event")
    private Set<EmployeeEventAssignment> employeeEventAssignmentSet = new HashSet<>();
    @OneToMany(mappedBy = "event")
    private Set<EventNote> eventNotes = new HashSet<>();

    public Event() {

    }

    public Event(String name, String eventType) {
        this.name = name;
        this.eventType = eventType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Set<EmployeeEventAssignment> getEmployeeEventAssignmentSet() {
        return employeeEventAssignmentSet;
    }

    public void setEmployeeEventAssignmentSet(Set<EmployeeEventAssignment> employeeEventAssignmentSet) {
        this.employeeEventAssignmentSet = employeeEventAssignmentSet;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                ", employeeEventAssignmentSet=" + employeeEventAssignmentSet +
                '}';
    }
}
