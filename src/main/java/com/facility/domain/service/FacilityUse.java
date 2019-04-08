package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.FacilityWorker;
import com.facility.domain.model.Status;
import com.facility.domain.model.Usage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FacilityUse {

    boolean isInUseDuringInterval(Date start, Date end);

    void assignFacilityToUse();

    void vacateFacility();

    List<Usage> listActualUsage();

    String calcUsageRate();

    List<Usage> getUsages();

    void addFacilityWorker(FacilityWorker facilityWorker);

    void removeFacilityWorker(FacilityWorker worker);
}
