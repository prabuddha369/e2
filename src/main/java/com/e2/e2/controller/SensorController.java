package com.e2.e2.controller;

import com.e2.e2.entity.Sensor;
import com.e2.e2.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sensors/")
public class SensorController extends BaseController<Sensor> {
    private final SensorService service;
    public SensorController(SensorService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Sensor> create(@RequestBody Sensor e) { return ok(service.create(e)); }

    @GetMapping
    public ResponseEntity<List<Sensor>> all() { return ok(service.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity<Sensor> byId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Sensor> update(@PathVariable Long id, @RequestBody Sensor e) { return ok(service.update(id, e)); }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    
    @GetMapping("by-warehouse/{warehouseId}")
    public ResponseEntity<List<Sensor>> byWarehouse(@PathVariable Long warehouseId) {
        return ok(service.findAll().stream().filter(s -> s.getWarehouse()!=null && s.getWarehouse().getId().equals(warehouseId)).toList());
    }

}
