package com.e2.e2.repository;

import com.e2.e2.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Custom finders
}
