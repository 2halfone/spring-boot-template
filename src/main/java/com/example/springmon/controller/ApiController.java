package com.example.springmon.controller;

import com.example.springmon.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(applicationService.getHealthStatus());
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        return ResponseEntity.ok(applicationService.getApplicationInfo());
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> status() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "RUNNING");
        status.put("version", applicationService.getApplicationVersion());
        status.put("uptime", System.currentTimeMillis());
        status.put("memory-total", Runtime.getRuntime().totalMemory());
        status.put("memory-free", Runtime.getRuntime().freeMemory());
        status.put("processors", Runtime.getRuntime().availableProcessors());
        return ResponseEntity.ok(status);
    }

    // Generic CRUD endpoints for any domain
    @GetMapping("/entities")
    public ResponseEntity<List<Map<String, Object>>> getAllEntities() {
        List<Map<String, Object>> entities = new ArrayList<>();
        // This will return empty list - ready for custom implementation
        return ResponseEntity.ok(entities);
    }

    @PostMapping("/entities")
    public ResponseEntity<Map<String, Object>> createEntity(@RequestBody Map<String, Object> entity) {
        // Generic entity creation - ready for custom implementation
        entity.put("id", System.currentTimeMillis()); // Temporary ID generation
        entity.put("created_at", System.currentTimeMillis());
        entity.put("updated_at", System.currentTimeMillis());
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/entities/{id}")
    public ResponseEntity<Map<String, Object>> getEntity(@PathVariable Long id) {
        Map<String, Object> entity = new HashMap<>();
        entity.put("id", id);
        entity.put("message", "Entity endpoint ready for implementation");
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/entities/{id}")
    public ResponseEntity<Map<String, Object>> updateEntity(@PathVariable Long id, @RequestBody Map<String, Object> entity) {
        entity.put("id", id);
        entity.put("updated_at", System.currentTimeMillis());
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/entities/{id}")
    public ResponseEntity<Map<String, String>> deleteEntity(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Entity " + id + " deleted successfully");
        return ResponseEntity.ok(response);
    }
}
