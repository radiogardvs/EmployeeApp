package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.EventNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventNoteRepository extends JpaRepository<EventNote,Long> {
}
