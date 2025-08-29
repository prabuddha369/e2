package com.e2.e2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique = true)
    private String email;

    @Column(nullable=false)
    private String name;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ADMIN;

    private Boolean active = true;

    private Instant createdAt = Instant.now();
}
