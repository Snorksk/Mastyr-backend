package com.diplom.hotels.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Дата заезда обязательна")
    @FutureOrPresent(message = "Дата заезда не может быть в прошлом")
    private LocalDate checkInDate;

    @NotNull(message = "Дата выезда обязательна")
    @Future(message = "Дата выезда должна быть в будущем")
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @NotNull(message = "Номер обязателен")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "Пользователь обязателен")
    private User user;
}
