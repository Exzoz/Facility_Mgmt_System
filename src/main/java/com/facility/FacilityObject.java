package com.facility;

import java.time.Period;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class FacilityObject implements Facility, FacilityUse, FacilityMaintenance {

    private Date created;
    private int capacity;
    private Status status;
    private List<Facility> facilities;
    private List<Usage> usages;
    private List<FacilityDetail> facilityDetails;
    private List<Maintenance> maintenances;
    private List<FacilityProblem> facilityProblems;
    private List<MaintenanceRequest> maintenanceRequests;
    private List<Inspection> inspections;

    public FacilityObject() {}

    @Override
    public List<Facility> listFacilities() {
        for(Facility facility: facilities) {
            System.out.println(facility);
        }
        return facilities;
    }
    @Override
    public Facility getFacilityInformation() {
        System.out.println(this);
        return this;
    }
    @Override
    public int requestAvailableCapacity() {
        //calculating total capacity as a sum
        //we need to be careful to not make a loop when assigning facilities
        int total = capacity;
        for(Facility facility: facilities) {
            total += facility.requestAvailableCapacity();
        }
        return total;
    }
    @Override
    public Facility addNewFacility(Facility facility) {
        this.facilities.add(facility);
        return this;
    }
    @Override
    public Facility addFacilityDetail(FacilityDetail facilityDetail) {
        // TODO still
        return null;
    }
    @Override
    public Facility removeFacility(Facility facility) {
        this.facilities.remove(facility);
        return this;
    }

    @Override
    public boolean isInUseDuringInterval(Date start, Date end) {
        // TODO still
        return false;
    }

    @Override
    public void assignFacilityToUse() {
        // TODO still

    }

    @Override
    public Facility vacateFacility() {
        // TODO still
        return null;
    }

    @Override
    public List<Inspection> listInspections() {
        // TODO still
        return null;
    }

    @Override
    public List<> listActualUsage() {
        // TODO still
        return null;
    }

    @Override
    public double calcUsageRate() {
        // TODO still
        return 0;
    }

}
