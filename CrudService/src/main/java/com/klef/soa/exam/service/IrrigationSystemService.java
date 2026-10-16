
package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.soa.exam.entity.IrrigationSystem;
import com.klef.soa.exam.repository.IrrigationSystemRepository;

@Service
public class IrrigationSystemService {

    private final IrrigationSystemRepository repository;

    public IrrigationSystemService(
            IrrigationSystemRepository repository) {
        this.repository = repository;
    }

    public IrrigationSystem addSystem(IrrigationSystem system) {
        return repository.save(system);
    }

    public List<IrrigationSystem> getAllSystems() {
        return repository.findAll();
    }

    public String deleteSystem(Long id) {
        if (!repository.existsById(id)) {
            return "Irrigation system not found with ID: " + id;
        }

        repository.deleteById(id);
        return "Irrigation system deleted successfully. ID: " + id;
    }
}
