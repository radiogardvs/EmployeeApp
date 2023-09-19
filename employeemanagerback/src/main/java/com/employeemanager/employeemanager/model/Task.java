package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private Integer estimatedTime;
    private Integer effectiveTime;
    public Task(){
    }
    public Task(String title, Integer estimatedTime, Integer effectiveTime){
        this.title=title;
        this.estimatedTime=estimatedTime;
        this.effectiveTime=effectiveTime;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Integer effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", effectiveTime=" + effectiveTime +
                '}';
    }
}
