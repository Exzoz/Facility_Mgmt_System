package com.facility.domain.service;

import com.facility.domain.model.FacilityDetail;
import com.facility.domain.model.FacilityInformation;
import com.facility.domain.model.Facility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilityService implements Serializable {

    private Facility facility;
    private List<FacilityDetail> facilityDetails;
    private int capacity;
    private List<Facility> facilities;
    private FacilityInformation facilityInformation;

    public FacilityService() {

    }

    public FacilityService(Facility facility, int capacity) {
        this.facility = facility;
        this.facilityDetails = new ArrayList<>();
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public List<Facility> listFacilities() {
        for (Facility facility : facilities) {
            System.out.println(facility);
        }
        return facilities;
    }

    public FacilityInformation getFacilityInformation() {
        return facilityInformation;
    }

    public int requestAvailableCapacity() {
        //calculating total capacity as a sum of own one plus children.
        //we need to be careful to not make a loop when assigning facilities
        int total = capacity;
        for (Facility facility : facilities) {
            total += facility.getFacilityService().requestAvailableCapacity();
        }
        return total;
    }

    public void addNewFacility(Facility facility) {
        facilities.add(facility);
    }

    public void addFacilityDetail(String name, String description) {
        facilityDetails.add(new FacilityDetail(new Date(), name, description));
    }

    public void removeFacility(Facility facility) {
        facilities.remove(facility);
    }
}
