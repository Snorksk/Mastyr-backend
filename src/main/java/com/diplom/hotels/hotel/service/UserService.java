package com.diplom.hotels.hotel.service;

import com.diplom.hotels.hotel.model.Room;
import com.diplom.hotels.hotel.model.User;
import com.diplom.hotels.hotel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        Optional<User> existing = userRepository.findByUsername(user.getUsername());
        if (existing.isPresent()) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        userRepository.save(user);
    }
}
