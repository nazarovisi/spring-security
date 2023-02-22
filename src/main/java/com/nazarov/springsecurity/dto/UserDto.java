package com.nazarov.springsecurity.dto;

import com.nazarov.springsecurity.entites.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private List<Roles> roles;
}
