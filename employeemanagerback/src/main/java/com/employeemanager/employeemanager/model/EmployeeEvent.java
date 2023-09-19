package com.employeemanager.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EmployeeEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public EmployeeEvent() {
    }

    public EmployeeEvent(Employee employee, Event event) {
        this.employee = employee;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EmployeeEvent{" +
                "id=" + id +
                ", employee=" + employee +
                ", event=" + event +
                '}';
    }
}
