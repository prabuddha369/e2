package com.e2.e2.repository;

import com.e2.e2.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    // Custom finders
}
