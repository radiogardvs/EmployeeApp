package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.exception.NoteNotFoundException;
import com.employeemanager.employeemanager.model.Note;
import com.employeemanager.employeemanager.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    @Autowired
    public NoteService(NoteRepository noteRepository){
        this.noteRepository=noteRepository;
    }
    public Note addNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes(){
        return noteRepository.findAll();
    }

    public Note updateNote(Note note){
        return noteRepository.save(note);
    }

    public Note findNoteById(Long id){
        return noteRepository.findNoteById(id).orElseThrow(()-> new NoteNotFoundException("Note with id"+id+"was not found"));
    }
    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }

}
