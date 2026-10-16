
package com.klef.soa.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.soa.exam.entity.IrrigationSystem;

public interface IrrigationSystemRepository
        extends JpaRepository<IrrigationSystem, Long> {
}
