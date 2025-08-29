package com.e2.e2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class SensorReading {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false) @JoinColumn(name="sensor_id")
    private Sensor sensor;

    private Instant readingTime = Instant.now();

    // Generic value
    private Double value;

    // Optional structured values
    private Double temperatureC;
    private Double humidityPercent;

    private Instant createdAt = Instant.now();
}
