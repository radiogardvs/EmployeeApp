package com.employeemanager.employeemanager.exception;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String message){
        super(message);
    }
}
