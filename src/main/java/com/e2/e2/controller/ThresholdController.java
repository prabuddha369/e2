package com.e2.e2.controller;

import com.e2.e2.entity.Threshold;
import com.e2.e2.service.ThresholdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/thresholds/")
public class ThresholdController extends BaseController<Threshold> {
    private final ThresholdService service;
    public ThresholdController(ThresholdService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Threshold> create(@RequestBody Threshold e) { return ok(service.create(e)); }

    @GetMapping
    public ResponseEntity<List<Threshold>> all() { return ok(service.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity<Threshold> byId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Threshold> update(@PathVariable Long id, @RequestBody Threshold e) { return ok(service.update(id, e)); }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    
}
