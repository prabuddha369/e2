package com.e2.e2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneId;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @Column(nullable = false, unique = true)
    private String zoneName;

    private String description;

    private boolean humidityControl;
    private boolean temperatureControl;

    private String locationRef;

    private Instant createdAt = Instant.now();
}