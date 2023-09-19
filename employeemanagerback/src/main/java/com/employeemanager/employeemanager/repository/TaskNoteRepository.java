package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.TaskNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskNoteRepository extends JpaRepository<TaskNote,Long> {
}
