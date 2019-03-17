package com.facility.model;

import java.io.Serializable;
import java.util.Date;

public class FacilityProblem implements Serializable {
    private Date created;
    private String description;
    private boolean solved;

    public FacilityProblem(){
    }

    public FacilityProblem(Date created, String description, boolean solved) {
        this.created = created;
        this.description = description;
        this.solved = solved;
    }

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isSolved() {
        return solved;
    }
    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    @Override
    public String toString() {
        return "FacilityProblem{" +
                "created=" + created +
                ", description='" + description + '\'' +
                ", solved=" + solved +
                '}';
    }
}
