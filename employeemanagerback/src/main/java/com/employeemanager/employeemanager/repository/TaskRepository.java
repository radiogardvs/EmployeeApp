package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Optional<Task> findTaskById(Long id);
}
