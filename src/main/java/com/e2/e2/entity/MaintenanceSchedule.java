package com.e2.e2.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance_schedule")
public class MaintenanceSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_id")
    private int maintenanceId;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    private Sensor sensor;

    @Column(name = "maintenance_date")
    private LocalDateTime maintenanceDate;

    @Column(name = "maintenance_type")
    private String maintenanceType;

    @Column(name = "performed_by")
    private String performedBy;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters and setters
}