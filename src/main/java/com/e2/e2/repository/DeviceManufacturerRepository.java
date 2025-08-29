package com.e2.e2.repository;

import com.e2.e2.entity.DeviceManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface DeviceManufacturerRepository extends JpaRepository<DeviceManufacturer, Long> {
    // Custom finders
}
