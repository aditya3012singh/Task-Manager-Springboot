package com.aditya.taskmanager.service;

import com.aditya.taskmanager.config.security.JwtService;
import com.aditya.taskmanager.dto.request.LoginRequest;
import com.aditya.taskmanager.dto.request.RegisterReqeust;
import com.aditya.taskmanager.entity.Role;
import com.aditya.taskmanager.entity.User;
import com.aditya.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterReqeust request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already Exist");
        }

        User user= User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
    private final JwtService jwtService;
    public String login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new RuntimeException("Invalid Credentials"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credential");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
