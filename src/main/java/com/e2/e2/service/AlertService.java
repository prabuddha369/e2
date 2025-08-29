package com.e2.e2.service;

import com.e2.e2.entity.Alert;
import com.e2.e2.repository.AlertRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertService extends BaseService<Alert, AlertRepository> {
    public AlertService(AlertRepository repo) { super(repo); }
}
