package com.facility.runner;

import com.facility.model.FacilityObject;
import com.facility.model.Inspection;
import com.facility.model.Maintenance;
import com.facility.model.Usage;

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


    }
}
