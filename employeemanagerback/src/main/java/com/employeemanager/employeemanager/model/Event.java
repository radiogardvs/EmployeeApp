package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EmployeeEvent> employeeEventList;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventRoom> eventRoomList;

    public Event() {

    }

    public Event(String name) {
        this.name = name;
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

    public List<EmployeeEvent> getEmployeeEventList() {
        return employeeEventList;
    }

    public void setEmployeeEventList(List<EmployeeEvent> employeeEventList) {
        this.employeeEventList = employeeEventList;
    }

    public List<EventRoom> getEventRoomList() {
        return eventRoomList;
    }

    public void setEventRoomList(List<EventRoom> eventRoomList) {
        this.eventRoomList = eventRoomList;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeEventList=" + employeeEventList +
                ", eventRoomList=" + eventRoomList +
                '}';
    }
}
