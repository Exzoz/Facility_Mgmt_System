package com.facility.domain.service;

import com.facility.dal.persistence.SerializeUtils;
import com.facility.domain.model.Facility;

public interface PersistanceManager {

    void saveFacility(Facility facility);
    Facility loadFacility();
}
