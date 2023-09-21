package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_task")
public class EmployeeTaskAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeTaskAssignment{" +
                "id=" + id +
                ", employee=" + employee +
                ", task=" + task +
                '}';
    }
}
