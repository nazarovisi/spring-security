package com.nazarov.springsecurity.repository;

import com.nazarov.springsecurity.entites.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    List<Roles> findAll();
}
