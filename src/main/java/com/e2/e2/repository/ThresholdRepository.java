package com.e2.e2.repository;

import com.e2.e2.entity.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ThresholdRepository extends JpaRepository<Threshold, Long> {
    // Custom finders
}
