package com.facility.model;

import java.util.Date;


public class Usage {
    Date startDate;
    Date endDate;

    public Usage() {}

    public Usage(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Usage [startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}


