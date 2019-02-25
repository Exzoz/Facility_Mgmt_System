package com.facility.runner;

import com.facility.model.FacilityObject;
import com.facility.model.Inspection;
import com.facility.model.Maintenance;
import com.facility.model.Usage;
import com.facility.persistence.SerializeUtils;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Run Facility Management");
        System.out.println("Create new Facility");
        FacilityObject facility = new FacilityObject(20);
        facility.addNewFacility(new FacilityObject(1));
        facility.addNewFacility(new FacilityObject(2));
        facility.addNewFacility(new FacilityObject(3));
        System.out.println("Listing facilities");
        facility.listFacilities();
        facility.assignFacilityToUse();

        System.out.println("Adding Usage");
        facility.getUsages().add(new Usage());
        System.out.println("Adding Usage");
        facility.getUsages().add(new Usage());
        System.out.println("Adding Maintenance");
        facility.getMaintenances().add(new Maintenance());
        System.out.println("Usage rate: " + facility.calcUsageRate());

        Maintenance maintenance1 = new Maintenance(new Date(), null, 3);
        facility.getMaintenances().add(maintenance1);
        System.out.println("Adding maintenance:" + maintenance1);
        Maintenance maintenance2 = new Maintenance(new Date(), null, 4);
        facility.getMaintenances().add(maintenance2);
        System.out.println("Adding maintenance:" + maintenance2);
        Maintenance maintenance3 = new Maintenance(new Date(), null, 5);
        facility.getMaintenances().add(maintenance3);
        System.out.println("Adding maintenance:" + maintenance3);
        System.out.println("Maintenance cost: " + facility.calcMaintenanceCostForFacility());


        Inspection inspection1 = new Inspection(null, true);
        facility.getInspections().add(inspection1);
        System.out.println("Adding inspection:" + inspection1);
        Inspection inspection2 = new Inspection(null, false);
        facility.getInspections().add(inspection2);
        System.out.println("Adding inspection:" + inspection2);
        Inspection inspection3 = new Inspection(null, false);
        facility.getInspections().add(inspection3);
        System.out.println("Adding inspection:" + inspection3);
        System.out.println("Problem rate: " + facility.calcProblemRateForFacility());

        System.out.println("Saving facility object: " + facility);
        SerializeUtils.saveFacility(facility);

        System.out.println("Loading facility object");
        FacilityObject loadedObject = SerializeUtils.loadFacility();
        System.out.println("Loaded facility object:" + loadedObject);
    }
}


