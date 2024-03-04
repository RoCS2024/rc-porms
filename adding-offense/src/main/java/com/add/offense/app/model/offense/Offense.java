package com.add.offense.app.model.offense;

public class Offense {
    private Long id;
    private Long violationId;
    private String studentId;
//    private Timestamp offenseDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getViolationId() {
        return violationId;
    }

    public void setViolationId(Long violationId) {
        this.violationId = violationId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

//    public LocalDateTime getOffenseDate() {
//        return offenseDate.toLocalDateTime();
//    }

//    public void setOffenseDate(LocalDateTime offenseDate) {
//        this.offenseDate = Timestamp.valueOf(offenseDate);
//    }

}

