package com.example.CarDealer.Controllers;

import com.example.CarDealer.Models.UserModel;
import com.example.CarDealer.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth") // Base URL: localhost:8080/auth
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Signup API
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserModel user) {
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already registered!");
        }

        // Save user without password encryption
        userRepository.save(user);
        return ResponseEntity.ok("Signup successful!");
    }

    // Login API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModel loginUser) {
        Optional<UserModel> userOptional = userRepository.findByEmail(loginUser.getEmail());

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();

            // Check password without encryption
            if (loginUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.badRequest().body("Invalid credentials!");
            }
        } else {
            return ResponseEntity.badRequest().body("User not found!");
        }
    }
}
