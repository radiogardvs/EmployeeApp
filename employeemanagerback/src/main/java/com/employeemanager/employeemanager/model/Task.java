package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;
    private String title;
    private String description;
    private Integer estimatedTime;
    private Integer effectiveTime;
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

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Integer getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Integer effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
