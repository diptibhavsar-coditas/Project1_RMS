package com.example.RestaurantOnboarding.service.impl;

import com.example.RestaurantOnboarding.dto.AuthDto.AuthResponseDto;
import com.example.RestaurantOnboarding.dto.AuthDto.LoginRequestDto;
import com.example.RestaurantOnboarding.dto.UserDto.UserResponseDto;
import com.example.RestaurantOnboarding.entity.User;
import com.example.RestaurantOnboarding.exception.ResourceNotFoundException;
import com.example.RestaurantOnboarding.exception.UnauthorizedException;
import com.example.RestaurantOnboarding.mapper.UserMapper;
import com.example.RestaurantOnboarding.repository.UserRepository;
import com.example.RestaurantOnboarding.service.UserService;
import com.example.RestaurantOnboarding.util.JwtUtil;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()))
                )
        );

        return new AuthResponseDto(token, user.getRole().getRoleName(), "Login successful");
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.toDto(user);
    }
}