package com.prefect.office.record.management.data.dao.prefect.violation;

import com.prefect.office.record.management.appl.model.violation.Violation;

import java.util.List;

public interface ViolationDao {
    void addViolation(Violation violation);

    List<Violation> getAllViolation();
}

