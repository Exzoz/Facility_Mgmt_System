package com.facility;

import java.util.Date;

public class Inspection {
    private Date created;
    private boolean problemFound;

    public Inspection() []

    public Inspection(Date created, boolean problemFound) {
        this.created = created;
        this.problemFound = problemFound;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public boolean isProblemFound() {
        return problemFound;
    }
    public void setProblemFound(boolean problemFound) {
        this.problemFound = problemFound;
    }
    @Override
    public String toString() {
        return "Inspection [created=" + created + ", problemFound="
                + problemFound + "]";
    }
}



