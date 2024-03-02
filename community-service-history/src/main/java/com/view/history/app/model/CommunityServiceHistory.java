package com.view.history.app.model;

public class CommunityServiceHistory {

    private String id;

    private String studentId;

    private String dateRendered;

    private String hoursRendered;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDateRendered() {
        return dateRendered;
    }

    public void setDateRendered(String dateRendered) {
        this.dateRendered = dateRendered;
    }

    public String getHoursRendered() {
        return hoursRendered;
    }

    public void setHoursRendered(String hoursRendered) {
        this.hoursRendered = hoursRendered;
    }
}
