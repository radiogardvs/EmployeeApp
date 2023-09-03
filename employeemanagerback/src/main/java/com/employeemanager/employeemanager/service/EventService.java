package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.exception.EventNotFoundException;
import com.employeemanager.employeemanager.model.Note;
import com.employeemanager.employeemanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeemanager.employeemanager.model.Event;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }

    public Event addEvent(Event event){
        return eventRepository.save(event);
    }
    public List<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event){
        return eventRepository.save(event);
    }

    public Event findEventById(Long id){
        return eventRepository.findEventById(id).orElseThrow(()-> new EventNotFoundException("Event with id"+id+"was not found"));
    }
    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }

}
