package com.diplom.hotels.hotel.repository;

import com.diplom.hotels.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomIdAndCheckOutDateAfterAndCheckInDateBefore(Long roomId, LocalDate inDate, LocalDate outDate);

    List<Booking> findByUserId(Long userId);

    List<Booking> findByRoomId(Long roomId);
}
