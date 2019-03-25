package com.facility.service;

import com.facility.model.Facility;
import com.facility.model.Status;
import com.facility.model.Usage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilityUseService implements Serializable {

    private Facility facility;
    private Status status;
    private List<Usage> usages;

    public FacilityUseService() {

    }

    public FacilityUseService(Facility facility) {
        this.facility = facility;
        this.status = Status.FREE;
        this.usages = new ArrayList<>();
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Usage> getUsages() {
        return usages;
    }

    public void setUsages(List<Usage> usages) {
        this.usages = usages;
    }

    public boolean isInUseDuringInterval(Date start, Date end) {
        for (Usage usage : usages) {
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

    public void assignFacilityToUse() {
        this.status = Status.IN_USE;
    }

    public void vacateFacility() {
        this.status = Status.FREE;
    }


    public List<Usage> listActualUsage() {
        return usages;
    }

    public String calcUsageRate() {
        if (usages.size() == 0) {
            return "0";
        }
        return Utils.calculatePercentage(usages.size(), usages.size() + facility.getFacilityMaintenanceService().getMaintenances().size());
    }

}
