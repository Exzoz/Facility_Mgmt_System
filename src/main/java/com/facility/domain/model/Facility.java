package com.facility.domain.model;

import java.io.Serializable;
import java.util.Date;


public class Facility implements Serializable {

    private Date created;
    private int capacity;

    public Facility() {}

    public Facility(int capacity) {
        this.created = new Date();
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "Facility{" +
                "created=" + created +
                ", capacity=" + capacity +
                '}';
    }
}
