package com.prefect.office.record.management.appl.facade.prefect.violation;


public interface ViolationFacade {
    void addViolation(String violation, String type, int commServHours);
}