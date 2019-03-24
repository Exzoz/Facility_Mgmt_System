package com.facility.model;

import java.io.Serializable;

public class FacilityInformation implements Serializable{
    private String details;

    public FacilityInformation() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "FacilityInformation{" +
                "details='" + details + '\'' +
                '}';
    }
}
