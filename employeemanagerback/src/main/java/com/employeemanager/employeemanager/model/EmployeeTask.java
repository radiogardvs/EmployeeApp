package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EmployeeTask implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public EmployeeTask() {
    }

    public EmployeeTask(Employee employee, Task task) {
        this.employee = employee;
        this.task = task;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "EmployeeTask{" +
                "id=" + id +
                ", employee=" + employee +
                ", task=" + task +
                '}';
    }
}
