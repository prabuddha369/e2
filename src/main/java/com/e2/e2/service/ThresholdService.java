package com.e2.e2.service;

import com.e2.e2.entity.Threshold;
import com.e2.e2.repository.ThresholdRepository;
import org.springframework.stereotype.Service;

@Service
public class ThresholdService extends BaseService<Threshold, ThresholdRepository> {
    public ThresholdService(ThresholdRepository repo) { super(repo); }
}
