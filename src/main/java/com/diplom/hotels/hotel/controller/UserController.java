package com.diplom.hotels.hotel.controller;

import com.diplom.hotels.hotel.model.Room;
import com.diplom.hotels.hotel.model.User;
import com.diplom.hotels.hotel.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("Регистрация успешна");
    }

}
