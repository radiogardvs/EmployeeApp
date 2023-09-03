package com.employeemanager.employeemanager.exception;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String message){
        super(message);
    }
}
