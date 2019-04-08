package com.facility.domain.service;

import com.facility.domain.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FacilityMaintenance {

    List<Maintenance> getMaintenances();

    List<Inspection> getInspections();

    MaintenanceRequest makeFacilityMaintRequest();

    void scheduleMaintenance(Date date);

    int calcMaintenanceCostForFacility();

    List<Inspection> listInspections();

    String calcProblemRateForFacility();

    long calcDownTimeForFacility();

    List<MaintenanceRequest> listMaintRequests();

    List<Maintenance> listMaintenance();

    List<FacilityProblem> listFacilityProblems();
}
