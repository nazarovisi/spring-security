package com.nazarov.springsecurity.repository;

import com.nazarov.springsecurity.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAll();

    Optional<Users> findByUsername(String username);
}
