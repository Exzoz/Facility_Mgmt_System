package com.facility.model;

import com.facility.model.FacilityProblem;
import com.facility.model.Maintenance;
import com.facility.model.MaintenanceRequest;

import java.util.Date;
import java.util.List;


public interface FacilityMaintenance {

    MaintenanceRequest makeFacilityMaintRequest();

    void scheduleMaintenance(Date date);

    int calcMaintenanceCostForFacility();

    String calcProblemRateForFacility();

    long calcDownTimeForFacility();

    List<MaintenanceRequest> listMaintRequests();

    List<Maintenance> listMaintenance();

    List<FacilityProblem> listFacilityProblems();
}


