
package com.klef.soa.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IrrigationSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String systemName;

    public String systemType;

    public Double areaAcres;

    public Boolean automated;

    public IrrigationSystem() {
    }

    public IrrigationSystem(String systemName, String systemType,
                            Double areaAcres, Boolean automated) {
        this.systemName = systemName;
        this.systemType = systemType;
        this.areaAcres = areaAcres;
        this.automated = automated;
    }
}
