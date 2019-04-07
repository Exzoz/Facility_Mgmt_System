package com.facility.domain.service;

import com.facility.dal.persistence.SerializeUtils;
import com.facility.domain.model.Facility;

public class PersistanceManager {

    public PersistanceManager() {}

    public void saveFacility(Facility facility) {
        SerializeUtils.save(facility);
    }

    public Facility loadFacility() {
        return (Facility) SerializeUtils.load();
    }
}
