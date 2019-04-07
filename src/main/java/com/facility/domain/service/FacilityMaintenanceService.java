package com.facility.domain.service;

import com.facility.domain.model.*;
import com.facility.domain.service.impl.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilityMaintenanceService implements Serializable {

    private Facility facility;
    private List<Maintenance> maintenances;
    private List<FacilityProblem> facilityProblems;
    private List<MaintenanceRequest> maintenanceRequests;
    private List<Inspection> inspections;

    public FacilityMaintenanceService() {

    }

    public FacilityMaintenanceService(Facility facility) {
        this.facility = facility;
        this.maintenances = new ArrayList<>();
        this.facilityProblems = new ArrayList<>();
        this.maintenanceRequests = new ArrayList<>();
        this.inspections = new ArrayList<>();
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public List<FacilityProblem> getFacilityProblems() {
        return facilityProblems;
    }

    public void setFacilityProblems(List<FacilityProblem> facilityProblems) {
        this.facilityProblems = facilityProblems;
    }

    public List<MaintenanceRequest> getMaintenanceRequests() {
        return maintenanceRequests;
    }

    public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests) {
        this.maintenanceRequests = maintenanceRequests;
    }

    public MaintenanceRequest makeFacilityMaintRequest() {
        MaintenanceRequest request = new MaintenanceRequest();
        this.maintenanceRequests.add(request);
        return request;
    }

    public void scheduleMaintenance(Date date) {
        Maintenance maintenance = new Maintenance(date);
        this.maintenances.add(maintenance);
    }

    public int calcMaintenanceCostForFacility() {
        int total = 0;
        for (Maintenance maintenance : maintenances) {
            total += maintenance.getCost();
        }
        return total;
    }

    public List<Inspection> getInspections() {
        return inspections;
    }

    public void setInspections(List<Inspection> inspections) {
        this.inspections = inspections;
    }


    public List<Inspection> listInspections() {
        return inspections;
    }

    public String calcProblemRateForFacility() {
        int totalInspectionWithProblem = 0;
        for (Inspection inspection : inspections) {
            if (inspection.isProblemFound()) {
                totalInspectionWithProblem++;
            }
        }
        if (totalInspectionWithProblem == 0) {
            return "0";
        } else {
            return Utils.calculatePercentage(totalInspectionWithProblem, inspections.size());
        }
    }


    public long calcDownTimeForFacility() {
        //it will return number in hours
        long total = 0;
        for (Maintenance maintenance : maintenances) {
            total += (maintenance.getEnd().getTime() - maintenance.getStart().getTime()) / 1000;
        }
        return total / 3600;
    }


    public List<MaintenanceRequest> listMaintRequests() {
        for (MaintenanceRequest maintenanceRequest : maintenanceRequests) {
            System.out.println(maintenanceRequest);
        }
        return maintenanceRequests;
    }


    public List<Maintenance> listMaintenance() {
        for (Maintenance maintenance : maintenances) {
            System.out.println(maintenance);
        }
        return maintenances;
    }


    public List<FacilityProblem> listFacilityProblems() {
        for (FacilityProblem facilityProblem : facilityProblems) {
            System.out.println(facilityProblem);
        }
        return facilityProblems;
    }
}
