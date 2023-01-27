package com.example.jwt.controller;

import com.example.jwt.request.AuthenticationRequest;
import com.example.jwt.request.RegisterRequest;
import com.example.jwt.response.AuthenticationResponse;
import com.example.jwt.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "Authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @ApiOperation(value = "Register User")
    @PostMapping("/register")

    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }


    @ApiOperation(value = "Authenticate user")
    @PostMapping("/authenticate")

    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}