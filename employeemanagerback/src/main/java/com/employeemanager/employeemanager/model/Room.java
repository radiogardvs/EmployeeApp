package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<EventRoom> eventRoomList;

    public Room() {

    }

    public Room(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventRoom> getEventRoomList() {
        return eventRoomList;
    }

    public void setEventRoomList(List<EventRoom> eventRoomList) {
        this.eventRoomList = eventRoomList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventRoomList=" + eventRoomList +
                '}';
    }
}
