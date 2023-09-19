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
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<EmployeeTask> employeeTaskList;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<TaskNote> taskNoteList;
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

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public List<EmployeeTask> getEmployeeTaskList() {
        return employeeTaskList;
    }

    public void setEmployeeTaskList(List<EmployeeTask> employeeTaskList) {
        this.employeeTaskList = employeeTaskList;
    }

    public List<TaskNote> getTaskNoteList() {
        return taskNoteList;
    }

    public void setTaskNoteList(List<TaskNote> taskNoteList) {
        this.taskNoteList = taskNoteList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", effectiveTime=" + effectiveTime +
                ", employeeTaskList=" + employeeTaskList +
                ", taskNoteList=" + taskNoteList +
                '}';
    }
}
