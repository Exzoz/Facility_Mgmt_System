package com.facility;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public FacilityObject(int capacity) {
        this.created = new Date();
        this.capacity = capacity;
        this.status = Status.FREE;
        this.facilities = new ArrayList<>();
        this.usages = new ArrayList<>();
        this.facilityDetails = new ArrayList<>();
        this.maintenances = new ArrayList<>();
        this.facilityProblems = new ArrayList<>();
        this.maintenanceRequests = new ArrayList<>();
        this.inspections = new ArrayList<>();
    }


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
        for(Usage usage: usages) {
            if (dateBetween(usage.getStartDate(), start, end) ||  //if start date is between start and end
                    dateBetween(usage.getEndDate(), start, end) || //if end date is between start and end
                    (usage.getStartDate().before(start) && usage.getEndDate().after(end))) { //if usage start before start and usage end after end
                return true;
            }
        }
        return false;
    }

    private boolean dateBetween(Date d, Date min, Date max) {
        return d.after(min) && d.before(max);
    }

    @Override
    public void assignFacilityToUse() {
        this.status = Status.IN_USE;
    }

    @Override
    public void vacateFacility() {
        this.status = Status.FREE;
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
        if (usages.size() == 0) {
            return 0;
        }
        return usages.size() + maintenances.size() / usages.size();
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
        int total = 0;
        for (Maintenance maintenance: maintenances) {
            total += maintenance.getCost();
        }
        return total;
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

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<Usage> getUsages() {
        return usages;
    }

    public void setUsages(List<Usage> usages) {
        this.usages = usages;
    }

    public List<FacilityDetail> getFacilityDetails() {
        return facilityDetails;
    }

    public void setFacilityDetails(List<FacilityDetail> facilityDetails) {
        this.facilityDetails = facilityDetails;
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

    public List<Inspection> getInspections() {
        return inspections;
    }

    public void setInspections(List<Inspection> inspections) {
        this.inspections = inspections;
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
