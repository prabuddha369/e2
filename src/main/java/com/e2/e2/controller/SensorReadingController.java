package com.e2.e2.controller;

import com.e2.e2.entity.SensorReading;
import com.e2.e2.service.SensorReadingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/readings/")
public class SensorReadingController extends BaseController<SensorReading> {
    private final SensorReadingService service;
    public SensorReadingController(SensorReadingService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<SensorReading> create(@RequestBody SensorReading e) { return ok(service.create(e)); }

    @GetMapping
    public ResponseEntity<List<SensorReading>> all() { return ok(service.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity<SensorReading> byId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<SensorReading> update(@PathVariable Long id, @RequestBody SensorReading e) { return ok(service.update(id, e)); }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    
    @GetMapping("by-sensor/{sensorId}")
    public ResponseEntity<List<SensorReading>> bySensor(@PathVariable Long sensorId) {
        return ok(service.findAll().stream().filter(r -> r.getSensor()!=null && r.getSensor().getId().equals(sensorId)).toList());
    }

    @GetMapping("latest/{sensorId}")
    public ResponseEntity<SensorReading> latest(@PathVariable Long sensorId) {
        return ok(service.findAll().stream()
                .filter(r -> r.getSensor()!=null && r.getSensor().getId().equals(sensorId))
                .max(java.util.Comparator.comparing(SensorReading::getReadingTime))
                .orElse(null));
    }

}
