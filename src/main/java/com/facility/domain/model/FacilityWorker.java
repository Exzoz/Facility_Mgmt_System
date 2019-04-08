package com.facility.domain.model;

import java.util.Observable;
import java.util.Observer;

public class FacilityWorker implements Observer {

    private Facility assignedFacility;
    private String notes;

    @Override
    public void update(Observable o, Object facility) {
        System.out.println("Facility worker assigned to facility:" + facility);
        this.setAssignedFacility((Facility) facility);
    }

    public Facility getAssignedFacility() {
        return assignedFacility;
    }

    public void setAssignedFacility(Facility assignedFacility) {
        this.assignedFacility = assignedFacility;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
