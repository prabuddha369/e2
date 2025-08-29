package com.e2.e2.controller;

import com.e2.e2.entity.Alert;
import com.e2.e2.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts/")
public class AlertController extends BaseController<Alert> {
    private final AlertService service;
    public AlertController(AlertService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Alert> create(@RequestBody Alert e) { return ok(service.create(e)); }

    @GetMapping
    public ResponseEntity<List<Alert>> all() { return ok(service.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity<Alert> byId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Alert> update(@PathVariable Long id, @RequestBody Alert e) { return ok(service.update(id, e)); }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    
    @PostMapping("{id}/ack")
    public ResponseEntity<Alert> acknowledge(@PathVariable Long id) {
        return service.findById(id).map(a -> {
            a.setAcknowledged(true);
            a.setAcknowledgedAt(java.time.Instant.now());
            return ResponseEntity.ok(service.update(id, a));
        }).orElse(ResponseEntity.notFound().build());
    }

}
