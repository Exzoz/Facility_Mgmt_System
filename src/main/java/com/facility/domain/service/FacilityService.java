package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.FacilityDetail;
import com.facility.domain.model.FacilityInformation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FacilityService {

    List<Facility> listFacilities();

    FacilityInformation getFacilityInformation();

    int requestAvailableCapacity();

    void addNewFacility(Facility facility);

    void addFacilityDetail(String name, String description);

    void removeFacility(Facility facility);
}
