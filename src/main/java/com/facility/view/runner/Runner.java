package com.facility.view.runner;


import com.facility.domain.model.*;
import com.facility.domain.service.FacilityMaintenance;
import com.facility.domain.service.FacilityService;
import com.facility.domain.service.FacilityUse;
import com.facility.domain.service.impl.FacilityMaintenanceImpl;
import com.facility.domain.service.impl.FacilityServiceImpl;
import com.facility.domain.service.impl.FacilityUseServiceImpl;
import com.facility.domain.service.impl.PersistanceManagerImpl;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Run Facility Management");
        System.out.println("Create New Facility");
        Facility facility = new Facility(20);
        FacilityService facilityService = new FacilityServiceImpl(facility);
        facilityService.addNewFacility(new Facility(1));
        facilityService.addNewFacility(new Facility(2));
        facilityService.addNewFacility(new Facility(3));
        System.out.println("Listing Facilities");
        facilityService.listFacilities();
        FacilityUse facilityUse = new FacilityUseServiceImpl(facility);
        facilityUse.assignFacilityToUse();

        System.out.println("Adding Usage");
        facilityUse.getUsages().add(new Usage());
        System.out.println("Adding Usage");
        facilityUse.getUsages().add(new Usage());
        FacilityMaintenance facilityMaintenance = new FacilityMaintenanceImpl(facility);
        System.out.println("Adding Maintenance");
        facilityMaintenance.getMaintenances().add(new Maintenance());
        System.out.println("Usage Rate: " + facilityUse.calcUsageRate());

        Maintenance maintenance1 = new Maintenance(new Date(), null, 3);
        facilityMaintenance.getMaintenances().add(maintenance1);
        System.out.println("Adding Maintenance:" + maintenance1);
        Maintenance maintenance2 = new Maintenance(new Date(), null, 4);
        facilityMaintenance.getMaintenances().add(maintenance2);
        System.out.println("Adding Maintenance:" + maintenance2);
        Maintenance maintenance3 = new Maintenance(new Date(), null, 5);
        facilityMaintenance.getMaintenances().add(maintenance3);
        System.out.println("Adding Maintenance:" + maintenance3);
        System.out.println("Maintenance Cost: " + facilityMaintenance.calcMaintenanceCostForFacility());

        Inspection inspection1 = new Inspection(null, true);
        facilityMaintenance.getInspections().add(inspection1);
        System.out.println("Adding Inspection:" + inspection1);
        Inspection inspection2 = new Inspection(null, false);
        facilityMaintenance.getInspections().add(inspection2);
        System.out.println("Adding Inspection:" + inspection2);
        Inspection inspection3 = new Inspection(null, false);
        facilityMaintenance.getInspections().add(inspection3);
        System.out.println("Adding Inspection:" + inspection3);
        System.out.println("Problem Rate: " + facilityMaintenance.calcProblemRateForFacility());

        System.out.println("Saving Facility Object: " + facility);
        PersistanceManagerImpl persistanceManagerImpl = new PersistanceManagerImpl();
        persistanceManagerImpl.saveFacility(facility);

        System.out.println("Loading Facility Object");
        Facility loadedObject = persistanceManagerImpl.loadFacility();
        System.out.println("Loaded Facility Object:" + loadedObject);
    }
}
