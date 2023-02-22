package com.nazarov.springsecurity.controller;

import com.nazarov.springsecurity.dto.UserDto;
import com.nazarov.springsecurity.dto.UserRequest;
import com.nazarov.springsecurity.dto.UserResponse;
import com.nazarov.springsecurity.services.AuthServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServices authServices;

    @PostMapping("/insert")
    public ResponseEntity<UserResponse> insert(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authServices.insert(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authServices.login(userRequest));
    }
}
