package com.facility;

import java.time.Period;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class FacilityObject implements Facility, FacilityUse, FacilityMaintenance {

    private Date created;
    private int capacity;
    private Status status;
    private List<Facility> facilities;
    private List<Usage> usages;
    private List<FacilityDetail> facilityDetails;
    private List<Maintenance> maintenances;
    private List<FacilityProblem> facilityProblems;
    private List<MaintenanceRequest> maintenanceRequests;
    private List<Inspection> inspections;

    public FacilityObject() {}

    @Override
    public List<Facility> listFacilities() {
        for(Facility facility: facilities) {
            System.out.println(facility);
        }
        return facilities;
    }
    @Override
    public Facility getFacilityInformation() {
        System.out.println(this);
        return this;
    }
    @Override
    public int requestAvailableCapacity() {
        //calculating total capacity as a sum
        //we need to be careful to not make a loop when assigning facilities
        int total = capacity;
        for(Facility facility: facilities) {
            total += facility.requestAvailableCapacity();
        }
        return total;
    }
    @Override
    public Facility addNewFacility(Facility facility) {
        this.facilities.add(facility);
        return this;
    }
    @Override
    public Facility addFacilityDetail(String name, String description) {
        this.facilityDetails.add(new FacilityDetail(new Date(), name, description));
        return this;
    }
    @Override
    public Facility removeFacility(Facility facility) {
        this.facilities.remove(facility);
        return this;
    }

    @Override
    public boolean isInUseDuringInterval(Date start, Date end) {
        // TODO still
        return false;
    }

    @Override
    public void assignFacilityToUse() {
        // TODO still

    }

    @Override
    public Facility vacateFacility() {
        // TODO still
        return null;
    }

    @Override
    public List<Inspection> listInspections() {
        return inspections;
    }

    @Override
    public List<Usage> listActualUsage() {
        return usages;
    }

    @Override
    public double calcUsageRate() {
        // TODO still
        return 0;
    }

    @Override
    public MaintenanceRequest makeFacilityMaintRequest() {
        MaintenanceRequest request = new MaintenanceRequest();
        this.maintenanceRequests.add(request);
        return request;
    }

    @Override
    public void scheduleMaintenance(Date date) {
        Maintenance maintenance = new Maintenance(date);
        this.maintenances.add(maintenance);
    }

    @Override
    public int calcMaintenanceCostForFacility() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int calcProblemRateForFacility() {
        int totalInspectionWithProblem = 0;
        for (Inspection inspection: inspections) {
            if (inspection.isProblemFound()) {
                totalInspectionWithProblem++;
            }
        }
        if (totalInspectionWithProblem == 0) {
            return 0;
        } else {
            return inspections.size() / totalInspectionWithProblem;
        }
    }

    @Override
    public long calcDownTimeForFacility() {
        //it will return the number in hours
        long total = 0;
        for(Maintenance maintenance: maintenances) {
            total += (maintenance.getEnd().getTime() - maintenance.getStart().getTime()) / 1000;
        }
        return total / 3600;
    }


    @Override
    public List<MaintenanceRequest> listMaintRequests() {
        for (MaintenanceRequest maintenanceRequest : maintenanceRequests) {
            System.out.println(maintenanceRequest);
        }
        return maintenanceRequests;
    }

    @Override
    public List<Maintenance> listMaintenance() {
        for (Maintenance maintenance : maintenances) {
            System.out.println(maintenance);
        }
        return maintenances;
    }

    @Override
    public List<FacilityProblem> listFacilityProblems() {
        for (FacilityProblem facilityProblem : facilityProblems) {
            System.out.println(facilityProblem);
        }
        return facilityProblems;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public List<Facility> getFacilities() {
        return facilities;
    }

    public List<Usage> getUsages() {
        return usages;
    }

    public List<FacilityDetail> getFacilityDetails() {
        return facilityDetails;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    @Override
    public String toString() {
        return "FacilityObject [created=" + created + ", capacity=" + capacity
                + ", status=" + status + ", facilities=" + facilities
                + ", usages=" + usages + ", facilityDetails=" + facilityDetails
                + ", maintenances=" + maintenances + ", facilityProblems="
                + facilityProblems + ", maintenanceRequests="
                + maintenanceRequests + "]";
    }

}
