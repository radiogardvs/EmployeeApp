package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.EventNote;
import com.employeemanager.employeemanager.dto.EventNoteDTO;
import com.employeemanager.employeemanager.repository.EventNoteRepository;
import com.employeemanager.employeemanager.repository.EventRepository;
import com.employeemanager.employeemanager.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventNoteMapper {
    private final EventNoteRepository eventNoteRepository;
    private final EventRepository eventRepository;
    private final NoteRepository noteRepository;

    @Autowired
    public EventNoteMapper(EventNoteRepository eventNoteRepository, EventRepository eventRepository, NoteRepository noteRepository) {
        this.eventNoteRepository = eventNoteRepository;
        this.eventRepository = eventRepository;
        this.noteRepository = noteRepository;
    }

    public EventNoteDTO toDTO(EventNote eventNote) {
        EventNoteDTO eventNoteDTO = new EventNoteDTO();
        eventNoteDTO.setId(eventNote.getId());
        eventNoteDTO.setEventId(eventNote.getEvent().getId());
        eventNoteDTO.setNoteId(eventNote.getNote().getId());
        return eventNoteDTO;
    }

    public EventNote findEntity(EventNoteDTO eventNoteDTO) {
        return eventNoteRepository.findById(eventNoteDTO.getId()).orElseThrow();
    }

    public EventNote toEntity(EventNoteDTO eventNoteDTO) {
        EventNote eventNote = new EventNote();
        eventNote.setEvent(eventRepository.findById(eventNoteDTO.getEventId()).orElseThrow());
        eventNote.setNote(noteRepository.findById(eventNoteDTO.getNoteId()).orElseThrow());
        return eventNote;
    }

    public EventNote updateEntity(EventNoteDTO eventNoteDTO) {
        EventNote eventNote = eventNoteRepository.findById(eventNoteDTO.getId()).orElseThrow();
        eventNote.setEvent(eventRepository.findById(eventNoteDTO.getEventId()).orElseThrow());
        eventNote.setNote(noteRepository.findById(eventNoteDTO.getNoteId()).orElseThrow());
        return eventNote;
    }
}
