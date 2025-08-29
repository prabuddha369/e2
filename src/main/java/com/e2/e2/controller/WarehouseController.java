package com.e2.e2.controller;

import com.e2.e2.entity.Warehouse;
import com.e2.e2.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/warehouses/")
public class WarehouseController extends BaseController<Warehouse> {
    private final WarehouseService service;
    public WarehouseController(WarehouseService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Warehouse> create(@RequestBody Warehouse e) { return ok(service.create(e)); }

    @GetMapping
    public ResponseEntity<List<Warehouse>> all() { return ok(service.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity<Warehouse> byId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Warehouse> update(@PathVariable Long id, @RequestBody Warehouse e) { return ok(service.update(id, e)); }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    
}
