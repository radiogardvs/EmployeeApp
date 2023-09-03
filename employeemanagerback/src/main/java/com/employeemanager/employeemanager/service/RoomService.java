package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.exception.RoomNotFoundException;
import com.employeemanager.employeemanager.model.Room;
import com.employeemanager.employeemanager.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public List<Room> findAllRooms(){
        return roomRepository.findAll();
    }

    public Room updateRoom(Room room){
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id){
        return roomRepository.findRoomById(id).orElseThrow(()-> new RoomNotFoundException("Room with id"+id+"was not found"));
    }
    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }

}
