package com.prefect.office.record.management.app.model.communityservice;

import java.sql.Timestamp;

public class CommunityService {
    private int id;
    private String student_id;
    private Timestamp date_rendered;
    private int hours_rendered;

    public CommunityService() {

    }

    public CommunityService(int id, String student_id, Timestamp date_rendered, int hours_rendered) {
        this.id = id;
        this.student_id = student_id;
        this.date_rendered = date_rendered;
        this.hours_rendered = hours_rendered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Timestamp getDate_rendered() {
        return date_rendered;
    }

    public void setDate_rendered(Timestamp date_rendered) {
        this.date_rendered = date_rendered;
    }

    public int getHours_rendered() {
        return hours_rendered;
    }

    public void setHours_rendered(int hours_rendered) {
        this.hours_rendered = hours_rendered;
    }
}