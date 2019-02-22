package com.facility;

import java.util.Date;
import java.util.List;


public interface FacilityMaintenance {

    MaintenanceRequest makeFacilityMaintRequest();

    void scheduleMaintenance(Date date);

    int calcMaintenanceCostForFacility();

    int calcProblemRateForFacility();

    long calcDownTimeForFacility();

    List<MaintenanceRequest> listMaintRequests();

    List<Maintenance> listMaintenance();

    List<FacilityProblem> listFacilityProblems();
}


