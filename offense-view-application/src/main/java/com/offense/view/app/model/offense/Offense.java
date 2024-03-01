package com.offense.view.app.model.offense;

import java.sql.Timestamp;

public class Offense {
    private String id;
    private String violation_id;
    private String student_id;
    private Timestamp offense_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViolation_id() {
        return violation_id;
    }

    public void setViolation_id(String violation_id) {
        this.violation_id = violation_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Timestamp getOffense_date() {
        return offense_date;
    }

    public void setOffense_date(Timestamp offense_date) {
        this.offense_date = offense_date;
    }
}
