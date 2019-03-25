package com.facility.model;

import com.facility.service.FacilityMaintenanceService;
import com.facility.service.FacilityService;
import com.facility.service.FacilityUseService;

import java.io.Serializable;
import java.util.Date;


public class Facility implements Serializable {

    private Date created;

    private FacilityService facilityService;
    private FacilityMaintenanceService facilityMaintenanceService;
    private FacilityUseService facilityUseService;

    public Facility() {}

    public Facility(int capacity) {
        this.created = new Date();
        this.facilityService = new FacilityService(this, capacity);
        this.facilityMaintenanceService = new FacilityMaintenanceService(this);
        this.facilityUseService = new FacilityUseService(this);
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public FacilityService getFacilityService() {
        return facilityService;
    }

    public void setFacilityService(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    public FacilityMaintenanceService getFacilityMaintenanceService() {
        return facilityMaintenanceService;
    }

    public void setFacilityMaintenanceService(FacilityMaintenanceService facilityMaintenanceService) {
        this.facilityMaintenanceService = facilityMaintenanceService;
    }

    public FacilityUseService getFacilityUseService() {
        return facilityUseService;
    }

    public void setFacilityUseService(FacilityUseService facilityUseService) {
        this.facilityUseService = facilityUseService;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "created=" + created +
                ", facilityService=" + facilityService +
                ", facilityMaintenanceService=" + facilityMaintenanceService +
                ", facilityUseService=" + facilityUseService +
                '}';
    }
}
