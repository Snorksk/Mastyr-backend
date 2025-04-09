package com.diplom.hotels.hotel.service;

import com.diplom.hotels.hotel.model.Room;
import com.diplom.hotels.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository repo) {
        this.roomRepository = repo;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
    // Обновление комнаты по ID
    public Room updateRoom(Long id, Room updatedRoom) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Комната не найдена"));

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setType(updatedRoom.getType());
        room.setPrice(updatedRoom.getPrice());
        room.setStatus(updatedRoom.getStatus());

        return roomRepository.save(room);
    }

    // Удаление комнаты по ID
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
