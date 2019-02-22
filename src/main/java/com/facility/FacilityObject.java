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

    public FacilityObject(FacilityDetail facilityDetail, Date created,
                          int capacity, FacilityStatus status, List<Facility> facilities) {
        this.facilityDetail = facilityDetail;
        this.created = created;
        this.capacity = capacity;
        this.status = status;
        this.facilities = facilities;
    }

    
    @Override
    public List<Facility> listFacilities() {
        // TODO still
        return null;
    }
    @Override
    public Facility getFacilityInformation() {
        // TODO still
        return null;
    }
    @Override
    public void requestAvailableCapacity() {
        // TODO still

    }
    @Override
    public Facility addNewFacility(Facility facility) {
        // TODO still
        return null;
    }
    @Override
    public Facility addFacilityDetail(FacilityDetail facilityDetail) {
        // TODO still
        return null;
    }
    @Override
    public Facility removeFacility(Facility facility) {
        // TODO still
        return null;
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
    public List<FacilityUsage> listActualUsage() {
        // TODO still
        return null;
    }

    @Override
    public double calcUsageRate() {
        // TODO still
        return 0;
    }

}
