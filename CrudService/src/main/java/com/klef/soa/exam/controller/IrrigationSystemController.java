package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.exam.entity.IrrigationSystem;
import com.klef.soa.exam.service.IrrigationSystemService;

@RestController
@RequestMapping("/")
public class IrrigationSystemController {

    private final IrrigationSystemService service;

    public IrrigationSystemController(IrrigationSystemService service) {
        this.service = service;
    }

    @GetMapping
    public String home() {
        return "Irrigation System CRUD Service is Running";
    }

    @PostMapping("/Add")
    public ResponseEntity<IrrigationSystem> addSystem(
            @RequestBody IrrigationSystem system) {

        IrrigationSystem savedSystem = service.addSystem(system);

        return new ResponseEntity<>(
                savedSystem, HttpStatus.CREATED);
    }

    @GetMapping("/DisplayAll")
    public ResponseEntity<List<IrrigationSystem>> displayAll() {

        List<IrrigationSystem> systems = service.getAllSystems();

        return ResponseEntity.ok(systems);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteSystem(@PathVariable Long id) {

        if (!service.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Irrigation system not found with ID: " + id);
        }

        service.deleteSystem(id);

        return ResponseEntity.ok(
                "Irrigation system deleted successfully");
    }
}
