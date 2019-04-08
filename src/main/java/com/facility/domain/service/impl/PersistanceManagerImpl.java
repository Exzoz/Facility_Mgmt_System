package com.facility.domain.service.impl;

import com.facility.dal.persistence.SerializeUtils;
import com.facility.domain.model.Facility;
import com.facility.domain.service.PersistanceManager;

public class PersistanceManagerImpl implements PersistanceManager {

    public PersistanceManagerImpl() {}

    @Override
    public void saveFacility(Facility facility) {
        SerializeUtils.save(facility);
    }

    @Override
    public Facility loadFacility() {
        return (Facility) SerializeUtils.load();
    }
}
