package com.e2.e2.service;

import com.e2.e2.entity.AlertTicket;
import com.e2.e2.repository.AlertTicketRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertTicketService extends BaseService<AlertTicket, AlertTicketRepository> {
    public AlertTicketService(AlertTicketRepository repo) { super(repo); }
}
