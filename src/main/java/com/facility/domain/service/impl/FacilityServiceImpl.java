package com.facility.domain.service.impl;

import com.facility.domain.model.FacilityDetail;
import com.facility.domain.model.FacilityInformation;
import com.facility.domain.model.Facility;
import com.facility.domain.service.FacilityService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilityServiceImpl implements FacilityService, Serializable {

    private Facility facility;
    private List<FacilityDetail> facilityDetails;
    private List<Facility> facilities;
    private FacilityInformation facilityInformation;

    public FacilityServiceImpl() {}

    public FacilityServiceImpl(Facility facility) {
        this.facility = facility;
        this.facilityDetails = new ArrayList<>();
        this.facilities = new ArrayList<>();
        this.facilityInformation = new FacilityInformation();
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<FacilityDetail> getFacilityDetails() {
        return facilityDetails;
    }

    public void setFacilityDetails(List<FacilityDetail> facilityDetails) {
        this.facilityDetails = facilityDetails;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public void setFacilityInformation(FacilityInformation facilityInformation) {
        this.facilityInformation = facilityInformation;
    }

    @Override
    public List<Facility> listFacilities() {
        for (Facility facility : facilities) {
            System.out.println(facility);
        }
        return facilities;
    }

    @Override
    public FacilityInformation getFacilityInformation() {
        return facilityInformation;
    }

    @Override
    public int requestAvailableCapacity() {
        //calculating total capacity as a sum of own one plus children.
        //we need to be careful to not make a loop when assigning facilities
        int total = facility.getCapacity();
        for (Facility facility : facilities) {
            total += facility.getCapacity();
        }
        return total;
    }

    @Override
    public void addNewFacility(Facility facility) {
        facilities.add(facility);
    }

    @Override
    public void addFacilityDetail(String name, String description) {
        facilityDetails.add(new FacilityDetail(new Date(), name, description));
    }

    @Override
    public void removeFacility(Facility facility) {
        facilities.remove(facility);
    }
}
