package com.prefect.office.record.management.app.facade.prefect.violation;


import com.prefect.office.record.management.app.model.violation.Violation;

import java.util.List;

public interface ViolationFacade {
    void addViolation(String violation, String type, int commServHours);
    List<Violation> getAllViolation();
}