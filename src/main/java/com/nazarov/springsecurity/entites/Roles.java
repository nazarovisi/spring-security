package com.nazarov.springsecurity.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String keyword;
    @ManyToMany(mappedBy = "roles")
    List<Users> users;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean deleted;
}
