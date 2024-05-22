package com.example.Example.user.service;

import com.example.Example.user.model.User;
import com.example.Example.user.repo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> login(String username, String password) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return ResponseEntity.ok(new LoginResponse(true, user.getId()));
            }
        }

        return ResponseEntity.ok(new LoginResponse(false, 0));
    }

    public static class LoginResponse {
        private final boolean success;
        private final long userId;

        public LoginResponse(boolean success, long userId) {
            this.success = success;
            this.userId = userId;
        }

        public boolean isSuccess() {
            return success;
        }

        public long getUserId() {
            return userId;
        }
    }
}
