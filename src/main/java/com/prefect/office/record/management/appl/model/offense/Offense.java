package com.prefect.office.record.management.appl.model.offense;

import com.prefect.office.record.management.appl.model.violation.Violation;
import com.student.information.management.appl.model.student.Student;

import java.sql.Timestamp;

public class Offense {
    private int id;
    private Violation violation;
    private Student student;
    private Timestamp offenseDate;
    private int commServHours;

    public Offense(int id, Violation violation, Student student, Timestamp offenseDate, int commServHours) {
        this.id = id;
        this.violation = violation;
        this.student = student;
        this.offenseDate = offenseDate;
        this.commServHours = commServHours;
    }

    public Offense() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Timestamp getOffenseDate() {
        return offenseDate;
    }

    public void setOffenseDate(Timestamp offenseDate) {
        this.offenseDate = offenseDate;
    }

    public int getCommServHours() {
        return commServHours;
    }

    public void setCommServHours(int commServHours) {
        this.commServHours = commServHours;
    }
}
