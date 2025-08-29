package com.e2.e2.repository;

import com.e2.e2.entity.AlertTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AlertTicketRepository extends JpaRepository<AlertTicket, Long> {
    // Custom finders
}
