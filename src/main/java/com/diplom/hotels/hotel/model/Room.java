package com.diplom.hotels.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Номер комнаты не должен быть пустым")
    private String roomNumber;

    @NotBlank(message = "Тип комнаты обязателен")
    private String type;

    @NotNull(message = "Цена обязательна")
    @DecimalMin(value = "0.0", inclusive = false, message = "Цена должна быть больше 0")
    private Double price;

    @NotBlank(message = "Статус комнаты обязателен")
    private String status;

    // Геттеры/сеттеры
}