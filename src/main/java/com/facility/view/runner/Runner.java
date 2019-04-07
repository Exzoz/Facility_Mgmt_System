package com.facility.view.runner;

import com.facility.domain.model.*;
import com.facility.domain.service.PersistanceManager;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Run Facility Management");
        System.out.println("Create new Facility");
        Facility facility = new Facility(20);
        facility.getFacilityService().addNewFacility(new Facility(1));
        facility.getFacilityService().addNewFacility(new Facility(2));
        facility.getFacilityService().addNewFacility(new Facility(3));
        System.out.println("Listing facilities");
        facility.getFacilityService().listFacilities();
        facility.getFacilityUseService().assignFacilityToUse();

        System.out.println("Adding Usage");
        facility.getFacilityUseService().getUsages().add(new Usage());
        System.out.println("Adding Usage");
        facility.getFacilityUseService().getUsages().add(new Usage());
        System.out.println("Adding Maintenance");
        facility.getFacilityMaintenanceService().getMaintenances().add(new Maintenance());
        System.out.println("Usage rate: " + facility.getFacilityUseService().calcUsageRate());

        Maintenance maintenance1 = new Maintenance(new Date(), null, 3);
        facility.getFacilityMaintenanceService().getMaintenances().add(maintenance1);
        System.out.println("Adding maintenance:" + maintenance1);
        Maintenance maintenance2 = new Maintenance(new Date(), null, 4);
        facility.getFacilityMaintenanceService().getMaintenances().add(maintenance2);
        System.out.println("Adding maintenance:" + maintenance2);
        Maintenance maintenance3 = new Maintenance(new Date(), null, 5);
        facility.getFacilityMaintenanceService().getMaintenances().add(maintenance3);
        System.out.println("Adding maintenance:" + maintenance3);
        System.out.println("Maintenance cost: " + facility.getFacilityMaintenanceService().calcMaintenanceCostForFacility());

        Inspection inspection1 = new Inspection(null, true);
        facility.getFacilityMaintenanceService().getInspections().add(inspection1);
        System.out.println("Adding inspection:" + inspection1);
        Inspection inspection2 = new Inspection(null, false);
        facility.getFacilityMaintenanceService().getInspections().add(inspection2);
        System.out.println("Adding inspection:" + inspection2);
        Inspection inspection3 = new Inspection(null, false);
        facility.getFacilityMaintenanceService().getInspections().add(inspection3);
        System.out.println("Adding inspection:" + inspection3);
        System.out.println("Problem rate: " + facility.getFacilityMaintenanceService().calcProblemRateForFacility());

        System.out.println("Saving facility object: " + facility);
        PersistanceManager persistanceManager = new PersistanceManager();
        persistanceManager.saveFacility(facility);

        System.out.println("Loading facility object");
        Facility loadedObject = persistanceManager.loadFacility();
        System.out.println("Loaded facility object:" + loadedObject);
    }
}
