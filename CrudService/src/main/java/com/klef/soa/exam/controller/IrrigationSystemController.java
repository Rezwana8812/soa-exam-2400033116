
package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.exam.entity.IrrigationSystem;
import com.klef.soa.exam.service.IrrigationSystemService;

@RestController
public class IrrigationSystemController {

    private final IrrigationSystemService service;

    public IrrigationSystemController(IrrigationSystemService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "IrrigationSystem CRUD Service is running!";
    }

    @PostMapping("/Add")
    public IrrigationSystem add(
            @RequestBody IrrigationSystem system) {
        return service.addSystem(system);
    }

    @GetMapping("/DisplayAll")
    public List<IrrigationSystem> displayAll() {
        return service.getAllSystems();
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {
        String result = service.deleteSystem(id);

        if (result.startsWith("Irrigation system not found")) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }
}
