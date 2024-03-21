package com.prefect.office.record.management.app.facade.prefect.violation;


public interface ViolationFacade {
    void addViolation(String violation, String type, int commServHours);
}