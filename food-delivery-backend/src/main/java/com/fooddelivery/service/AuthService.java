package com.fooddelivery.service;

import com.fooddelivery.dto.*;
import com.fooddelivery.User;
import com.fooddelivery.repository.UserRepository;
import com.fooddelivery.config.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public JwtResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        if (request.getRole() != null) {
            user.setRole(User.Role.valueOf(request.getRole()));
        }

        User saved = userRepository.save(user);
        String token = jwtUtil.generateToken(saved.getEmail());

        return new JwtResponse(token, "Bearer", saved.getId(),
                saved.getName(), saved.getEmail(),
                saved.getRole().name());
    }

    public JwtResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new JwtResponse(token, "Bearer", user.getId(),
                user.getName(), user.getEmail(),
                user.getRole().name());
    }
}