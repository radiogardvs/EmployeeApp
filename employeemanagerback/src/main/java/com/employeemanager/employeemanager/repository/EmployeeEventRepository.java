package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeEventRepository extends JpaRepository<EmployeeEvent, Long> {
}
