package com.facility.service;

import com.facility.dal.persistence.SerializeUtils;
import com.facility.model.Facility;

public class PersistanceManager {

    public PersistanceManager() {}

    public void saveFacility(Facility facility) {
        SerializeUtils.save(facility);
    }

    public Facility loadFacility() {
        return (Facility) SerializeUtils.load();
    }
}
