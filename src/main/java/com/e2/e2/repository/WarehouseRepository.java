package com.e2.e2.repository;

import com.e2.e2.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    // Custom finders
}
