package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Optional<Room> findRoomById(Long id);
}
