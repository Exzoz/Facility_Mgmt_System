package com.facility.domain.service.impl;

import com.facility.domain.model.Facility;
import com.facility.domain.model.Status;
import com.facility.domain.model.Usage;
import com.facility.domain.model.FacilityWorker;
import com.facility.domain.service.FacilityUse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class FacilityUseServiceImpl extends Observable implements FacilityUse, Serializable {

    private Facility facility;
    private Status status;
    private List<Usage> usages;
    private List<FacilityWorker> facilityWorkers;


    public FacilityUseServiceImpl(){}

    public FacilityUseServiceImpl(Facility facility) {
        this.facility = facility;
        this.status = Status.FREE;
        this.usages = new ArrayList<>();
        this.facilityWorkers = new ArrayList<>();
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

    @Override
    public void addFacilityWorker(FacilityWorker worker) {
        //Add observer
        addObserver(worker);
        this.facilityWorkers.add(worker);
    }
    @Override
    public void removeFacilityWorker(FacilityWorker worker) {
        //Remove observer
        deleteObserver(worker);
        this.facilityWorkers.remove(worker);
    }

    @Override
    public List<Usage> getUsages() {
        return usages;
    }

    public void setUsages(List<Usage> usages) {
        this.usages = usages;
    }

    @Override
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

    /* Using observer pattern notify all facility workers assigned to this facility that facility is in use */
    @Override
    public void assignFacilityToUse() {
        this.status = Status.IN_USE;
        setChanged();
        notifyObservers(facility);
    }

    @Override
    public void vacateFacility() {
        this.status = Status.FREE;
    }

    @Override
    public List<Usage> listActualUsage() {
        return usages;
    }

    @Override
    public String calcUsageRate() {
        if (usages.size() == 0) {
            return "0";
        }
        long lifeMillis = differenceBetweenDates(facility.getCreated(), new Date());
        long totalUsage = 0;
        for(Usage usage: usages) {
            totalUsage += differenceBetweenDates(usage.getStartDate(), usage.getEndDate() == null ? new Date() : usage.getEndDate());
        }
        return Utils.calculatePercentage(totalUsage, lifeMillis);
    }

    private long differenceBetweenDates(Date startDate, Date endDate) {
        return Math.abs(endDate.getTime() - startDate.getTime());
    }
}
