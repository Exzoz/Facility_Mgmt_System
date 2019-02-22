package com.facility;

import java.util.Date;
import java.util.List;


public class FacilityObject implements Facility, FacilityUse {

    protected FacilityDetail facilityDetail;
    protected Date created;
    protected int capacity;
    protected FacilityStatus status;
    protected List<Facility> facilities;

    public FacilityObject() {
        super();
    }

    public FacilityObject(FacilityDetail facilityDetail, Date created,
                          int capacity, FacilityStatus status, List<Facility> facilities) {
        this.facilityDetail = facilityDetail;
        this.created = created;
        this.capacity = capacity;
        this.status = status;
        this.facilities = facilities;
    }

    public FacilityDetail getFacilityDetail() {
        return facilityDetail;
    }
    public void setFacilityDetail(FacilityDetail facilityDetail) {
        this.facilityDetail = facilityDetail;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public FacilityStatus getStatus() {
        return status;
    }
    public void setStatus(FacilityStatus status) {
        this.status = status;
    }
    public List<Facility> getFacilities() {
        return facilities;
    }
    public void setFacilities(List<Facility> facilities) {
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
