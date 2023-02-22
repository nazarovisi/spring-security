package com.nazarov.springsecurity.services;

import com.nazarov.springsecurity.dto.UserDto;
import com.nazarov.springsecurity.dto.UserRequest;
import com.nazarov.springsecurity.dto.UserResponse;
import com.nazarov.springsecurity.entites.Users;
import com.nazarov.springsecurity.exceptions.AlreadyExistException;
import com.nazarov.springsecurity.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServices {

    private final UsersRepository usersRepository;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public UserResponse insert(UserDto userDto){
        Optional<Users> usersOptional = usersRepository.findByUsername(userDto.getUsername());
        if (usersOptional.isPresent()) {
            throw new AlreadyExistException();
        } else {
            Users users = Users.builder()
                    .fullname(userDto.getFullname())
                    .username(userDto.getUsername())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .email(userDto.getEmail())
                    .roles(new ArrayList<>())
                    .deleted(false)
                    .build();
            usersRepository.save(users);
            String token = jwtService.generateToken(users);
            return UserResponse.builder().token(token).build();
        }

    }

    public UserResponse login(UserRequest userRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        Users users = usersRepository.findByUsername(userRequest.getUsername()).orElseThrow();
        String token = jwtService.generateToken(users);
        return UserResponse.builder().token(token).build();
    }

}
