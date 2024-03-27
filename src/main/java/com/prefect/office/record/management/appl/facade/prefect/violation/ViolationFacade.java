package com.prefect.office.record.management.appl.facade.prefect.violation;


import com.prefect.office.record.management.appl.model.violation.Violation;

import java.util.List;

public interface ViolationFacade {
    void addViolation(String violation, String type, int commServHours);

    List<Violation> getAllViolation();
}