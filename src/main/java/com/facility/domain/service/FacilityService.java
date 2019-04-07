package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.FacilityDetail;
import com.facility.domain.model.FacilityInformation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FacilityService  {

    public List<Facility> listFacilities();
    public FacilityInformation getFacilityInformation();
    public int requestAvailableCapacity();
    public void addNewFacility(Facility facility);
    public void addFacilityDetail(String name, String description);
    public void removeFacility(Facility facility);
}
