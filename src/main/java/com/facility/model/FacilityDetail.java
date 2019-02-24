package com.facility.model;

import java.util.Date;

public class FacilityDetail {
    private Date created;
    private String name;
    private String description;

    public FacilityDetail() {}

    public FacilityDetail(Date created, String name, String description) {
        this.created = created;
        this.name = name;
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FacilityDetail [created=" + created + ", name=" + name
                + ", description=" + description + "]";
    }
}


