package com.klef.soa.exam.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.klef.soa.exam.entity.IrrigationSystem;
import com.klef.soa.exam.repository.IrrigationSystemRepository;

@Service
public class IrrigationSystemService {

    private final IrrigationSystemRepository repository;

    public IrrigationSystemService(IrrigationSystemRepository repository) {
        this.repository = repository;
    }

    public IrrigationSystem addSystem(IrrigationSystem system) {
        return repository.save(system);
    }

    public List<IrrigationSystem> getAllSystems() {
        return repository.findAll();
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void deleteSystem(Long id) {
        repository.deleteById(id);
    }
}
