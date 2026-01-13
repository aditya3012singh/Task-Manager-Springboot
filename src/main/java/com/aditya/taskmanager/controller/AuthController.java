package com.aditya.taskmanager.controller;

import com.aditya.taskmanager.dto.request.LoginRequest;
import com.aditya.taskmanager.dto.request.RegisterReqeust;
import com.aditya.taskmanager.dto.response.AuthResponse;
import com.aditya.taskmanager.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterReqeust request){
        authService.register(request);
        return new AuthResponse("User Registered Successfully");
    }

    @PostMapping("/login")
    public AuthResponse login (@Valid @RequestBody LoginRequest request){
        String token= authService.login(request);
        return new AuthResponse(token);
    }
}
