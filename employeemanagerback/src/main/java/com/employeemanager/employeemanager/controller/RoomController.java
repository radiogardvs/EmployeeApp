package com.employeemanager.employeemanager.controller;
import com.employeemanager.employeemanager.model.Room;
import com.employeemanager.employeemanager.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms= roomService.findAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id){
        Room room=roomService.findRoomById(id);
        return new ResponseEntity<>(room,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room){
        Room newRoom= roomService.addRoom(room);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room){
        Room updateRoom= roomService.updateRoom(room);
        return new ResponseEntity<>(updateRoom, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id){
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
