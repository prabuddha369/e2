package com.e2.e2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Sensor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String serialNumber;

    @Column(nullable=false)
    private String type;        // e.g., TEMP, HUMIDITY, GENERIC

    private String unit;        // e.g., C, %, ppm
    private String location;    // human readable

    @ManyToOne @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne @JoinColumn(name = "manufacturer_id")
    private DeviceManufacturer manufacturer;

    private Instant installedAt;
    private Instant lastHeartbeat;

    private Boolean active = true;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SensorReading> readings;
}
