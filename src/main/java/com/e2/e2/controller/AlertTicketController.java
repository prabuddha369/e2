package com.e2.e2.controller;

import com.e2.e2.entity.AlertTicket;
import com.e2.e2.service.AlertTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets/")
public class AlertTicketController extends BaseController<AlertTicket> {
    private final AlertTicketService service;
    public AlertTicketController(AlertTicketService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<AlertTicket> create(@RequestBody AlertTicket e) { return ok(service.create(e)); }

    @GetMapping
    public ResponseEntity<List<AlertTicket>> all() { return ok(service.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity<AlertTicket> byId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<AlertTicket> update(@PathVariable Long id, @RequestBody AlertTicket e) { return ok(service.update(id, e)); }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    
    @PostMapping("{id}/close")
    public ResponseEntity<AlertTicket> close(@PathVariable Long id) {
        return service.findById(id).map(t -> {
            t.setStatus(com.e2.e2.entity.TicketStatus.CLOSED);
            t.setClosedAt(java.time.Instant.now());
            return ResponseEntity.ok(service.update(id, t));
        }).orElse(ResponseEntity.notFound().build());
    }

}
