package com.facility.domain.service;

import com.facility.domain.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FacilityMaintenance {

    public List<Maintenance> getMaintenances();
    public List<Inspection> getInspections();
    public MaintenanceRequest makeFacilityMaintRequest();
    public void scheduleMaintenance(Date date);
    public int calcMaintenanceCostForFacility();
    public List<Inspection> listInspections();
    public String calcProblemRateForFacility();
    public long calcDownTimeForFacility();
    public List<MaintenanceRequest> listMaintRequests();
    public List<Maintenance> listMaintenance();
    public List<FacilityProblem> listFacilityProblems();
}
