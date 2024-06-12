package com.mcit.dockerdemo.service;

import com.mcit.dockerdemo.entity.User;
import com.mcit.dockerdemo.respository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user1) {
        return userRepository.save(user1);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
