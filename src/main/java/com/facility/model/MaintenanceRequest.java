package com.facility.model;

import java.util.Date;

public class MaintenanceRequest {
    private Date created;

    public MaintenanceRequest() {
        created = new Date();
    }

    public MaintenanceRequest(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "MainteinanceRequest [created=" + created + "]";
    }

}