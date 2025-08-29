package com.e2.e2.repository;

import com.e2.e2.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    // Custom finders
}
