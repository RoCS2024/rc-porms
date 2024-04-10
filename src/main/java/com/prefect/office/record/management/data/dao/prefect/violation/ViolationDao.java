package com.prefect.office.record.management.data.dao.prefect.violation;

import com.prefect.office.record.management.appl.model.violation.Violation;

import java.util.List;
/**
 * This is the interface for the ViolationDao
 */
public interface ViolationDao {

    /**
     * This adds Violation to the database
     * @param violation is the violation to add
     */
    void addViolation(Violation violation);

    /**
     * This retrieves all Violation from the database
     * @return list of Violation
     */
    List<Violation> getAllViolation();
}

