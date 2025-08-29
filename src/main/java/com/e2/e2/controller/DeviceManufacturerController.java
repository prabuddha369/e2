package com.e2.e2.controller;

import com.e2.e2.entity.DeviceManufacturer;
import com.e2.e2.service.DeviceManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/manufacturers/")
public class DeviceManufacturerController extends BaseController<DeviceManufacturer> {
    private final DeviceManufacturerService service;
    public DeviceManufacturerController(DeviceManufacturerService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<DeviceManufacturer> create(@RequestBody DeviceManufacturer e) { return ok(service.create(e)); }

    @GetMapping
    public ResponseEntity<List<DeviceManufacturer>> all() { return ok(service.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity<DeviceManufacturer> byId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<DeviceManufacturer> update(@PathVariable Long id, @RequestBody DeviceManufacturer e) { return ok(service.update(id, e)); }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    
}
