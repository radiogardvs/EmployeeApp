package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.EmployeeTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask,Long> {
}
