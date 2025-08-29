package com.e2.e2.repository;

import com.e2.e2.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {
    // Custom finders
}
