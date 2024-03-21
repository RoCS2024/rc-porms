package com.prefect.office.record.management.app.model.violation;

public class Violation {
    private int id;
    private String violation;
    private String type;
    private int commServHours;

    public Violation() {
    }

    public Violation(String violation, String type, int commServHours) {
        this.violation = violation;
        this.type = type;
        this.commServHours = commServHours;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getViolation() {
        return violation;
    }

    public String getType() {
        return type;
    }

    public int getCommServHours() {
        return commServHours;
    }

    public int getId() {
        return id;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCommServHours(int commServHours) {
        this.commServHours = commServHours;
    }
}
