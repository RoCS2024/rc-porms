package com.violation.app.model.item;

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
    }

    public String getViolation() {
        return null;
    }

    public String getType() {
        return null;
    }

    public int getCommServHours() {
        return 0;
    }

    public int getId() {
        return 0;
    }

    public void setViolation(String violation) {
    }

    public void setType(String type) {
    }

    public void setCommServHours(int commServHours) {
    }

}
