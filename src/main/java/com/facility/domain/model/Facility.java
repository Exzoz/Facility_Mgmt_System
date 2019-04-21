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

    public Facility(Builder builder) {
        this.created = builder.created;
        this.capacity = builder.capacity;
    }

    // Static class Builder
    public static class Builder {
        /// instance fields
        private Date created;
        private int capacity;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {}

        // Setter methods
        public Builder setCreated(Date created) {
            this.created = created;
            return this;
        }
        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        // build method to deal with outer class to return outer instance
        public Facility build() {
            return new Facility(this);
        }
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
