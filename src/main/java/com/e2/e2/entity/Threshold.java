package com.e2.e2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Threshold {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Apply either to a specific sensor or to a type
    @ManyToOne @JoinColumn(name="sensor_id")
    private Sensor sensor;

    private String sensorType; // alternative to sensor-specific

    private Double minValue;
    private Double maxValue;
    private Double warningMin;
    private Double warningMax;
    private Double criticalMin;
    private Double criticalMax;

    private String unit;
}
