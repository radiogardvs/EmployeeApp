package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note,Long> {
    Optional<Note> findNoteById(Long id);
}
