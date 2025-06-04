package com.example.springmon.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;

@Service
public class ApplicationService {

    public Map<String, Object> getApplicationInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", "SpringMon");
        info.put("version", "1.0.0");
        info.put("description", "Generic Spring Boot Application");
        info.put("status", "ACTIVE");
        return info;
    }

    public Map<String, Object> getHealthStatus() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("diskSpace", "AVAILABLE");
        health.put("database", "UP");
        health.put("timestamp", System.currentTimeMillis());
        return health;
    }

    public String getApplicationVersion() {
        return "1.0.0";
    }
}
