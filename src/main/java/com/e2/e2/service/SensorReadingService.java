package com.e2.e2.service;

import com.e2.e2.entity.*;
import com.e2.e2.repository.AlertRepository;
import com.e2.e2.repository.SensorReadingRepository;
import com.e2.e2.repository.ThresholdRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class SensorReadingService extends BaseService<SensorReading, SensorReadingRepository> {
    private final ThresholdRepository thresholdRepository;
    private final AlertRepository alertRepository;

    public SensorReadingService(SensorReadingRepository repo,
                                ThresholdRepository thresholdRepository,
                                AlertRepository alertRepository) {
        super(repo);
        this.thresholdRepository = thresholdRepository;
        this.alertRepository = alertRepository;
    }

    @Override
    public SensorReading create(SensorReading r) {
        r = super.create(r);
        evaluateThresholds(r);
        return r;
    }

    private void evaluateThresholds(SensorReading r) {
        // Simplified rule: choose sensor-specific threshold if exists else by type
        Threshold t = thresholdRepository.findAll().stream().filter(th ->
                (th.getSensor()!=null && th.getSensor().getId().equals(r.getSensor().getId()))
                || (th.getSensor()==null && th.getSensorType()!=null &&
                    th.getSensorType().equalsIgnoreCase(r.getSensor().getType()))
        ).findFirst().orElse(null);

        if (t == null || r.getValue()==null) return;

        double v = r.getValue();
        Severity sev = null;
        String msg = null;

        if (t.getCriticalMin()!=null && v < t.getCriticalMin()) { sev = Severity.CRITICAL; msg = "Below critical min"; }
        else if (t.getCriticalMax()!=null && v > t.getCriticalMax()) { sev = Severity.CRITICAL; msg = "Above critical max"; }
        else if (t.getWarningMin()!=null && v < t.getWarningMin()) { sev = Severity.WARNING; msg = "Below warning min"; }
        else if (t.getWarningMax()!=null && v > t.getWarningMax()) { sev = Severity.WARNING; msg = "Above warning max"; }

        if (sev != null) {
            Alert a = Alert.builder()
                    .sensor(r.getSensor())
                    .triggeredAt(Instant.now())
                    .severity(sev)
                    .message(msg + " (" + v + " " + (t.getUnit()==null?"" : t.getUnit()) + ")")
                    .build();
            alertRepository.save(a);
        }
    }
}
