package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.exception.EmployeeNotFoundException;
import com.employeemanager.employeemanager.model.Employee;
import com.employeemanager.employeemanager.model.EmployeeEvent;
import com.employeemanager.employeemanager.model.EmployeeTask;
import com.employeemanager.employeemanager.model.Task;
import com.employeemanager.employeemanager.repository.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;
    private final EventRepository eventRepository;
    private final EmployeeEventRepository employeeEventRepository;
    private final EmployeeTaskRepository employeeTaskRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeEventRepository employeeEventRepository, EmployeeTaskRepository employeeTaskRepository,
                           TaskRepository taskRepository, EventRepository eventRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeEventRepository = employeeEventRepository;
        this.employeeTaskRepository = employeeTaskRepository;
        this.taskRepository = taskRepository;
        this.eventRepository = eventRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with id" + id + "was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeTask assignTaskToEmployee(Long employeeId, Long taskId) {
        EmployeeTask employeeTask=new EmployeeTask();
        employeeTask.setEmployee(employeeRepository.findEmployeeById(employeeId).orElseThrow());//todo exception
        employeeTask.setTask(taskRepository.findTaskById(taskId).orElseThrow());
        return employeeTaskRepository.save(employeeTask);
    }
    public EmployeeEvent assignEventToEmployee(Long employeeId, Long eventId) {
        EmployeeEvent employeeEvent=new EmployeeEvent();
        employeeEvent.setEmployee(employeeRepository.findEmployeeById(employeeId).orElseThrow());//todo exception
        employeeEvent.setEvent(eventRepository.findEventById(eventId).orElseThrow());
        return employeeEventRepository.save(employeeEvent);
    }
}
