package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.Employee;
import com.employeemanager.employeemanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventById(Long id);
}
