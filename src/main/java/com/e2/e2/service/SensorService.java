package com.e2.e2.service;

import com.e2.e2.entity.Sensor;
import com.e2.e2.repository.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorService extends BaseService<Sensor, SensorRepository> {
    public SensorService(SensorRepository repo) { super(repo); }
}
