package com.diplom.hotels.hotel.controller;

import com.diplom.hotels.hotel.model.User;
import com.diplom.hotels.hotel.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginData) {
        return userRepository.findByUsername(loginData.getUsername())
                .map(user -> {
                    if (loginData.getPassword().equals(user.getPassword())) {
                        return ResponseEntity.ok("Успешный вход!");
                    } else {
                        return ResponseEntity.status(401).body("Неверный пароль");
                    }
                })
                .orElse(ResponseEntity.status(404).body("Пользователь не найден"));
    }
}
