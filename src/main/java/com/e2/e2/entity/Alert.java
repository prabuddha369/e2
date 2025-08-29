package com.e2.e2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Alert {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false) @JoinColumn(name="sensor_id")
    private Sensor sensor;

    private Instant triggeredAt = Instant.now();

    private String message;

    @Enumerated(EnumType.STRING)
    private Severity severity = Severity.WARNING;

    private Boolean acknowledged = false;
    private Instant acknowledgedAt;

    private Instant resolvedAt;
}
