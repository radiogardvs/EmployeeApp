package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL)
    private List<EventNote> eventNoteList;
    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL)
    private List<TaskNote> taskNoteList;

    public Note() {

    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EventNote> getEventNoteList() {
        return eventNoteList;
    }

    public void setEventNoteList(List<EventNote> eventNoteList) {
        this.eventNoteList = eventNoteList;
    }

    public List<TaskNote> getTaskNoteList() {
        return taskNoteList;
    }

    public void setTaskNoteList(List<TaskNote> taskNoteList) {
        this.taskNoteList = taskNoteList;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", eventNoteList=" + eventNoteList +
                ", taskNoteList=" + taskNoteList +
                '}';
    }
}
