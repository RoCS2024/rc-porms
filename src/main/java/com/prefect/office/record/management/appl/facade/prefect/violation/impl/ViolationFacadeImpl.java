package com.prefect.office.record.management.appl.facade.prefect.violation.impl;

import com.prefect.office.record.management.appl.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.student.information.management.appl.model.student.Student;

import java.util.List;

/**
 * An implementation class of the Offence Facade.
 */

public class ViolationFacadeImpl implements ViolationFacade {

    private ViolationDao violationDao;

    public ViolationFacadeImpl(ViolationDao violationDao) {
        this.violationDao = violationDao;
    }

    public ViolationFacadeImpl() {

    }

    public List<Violation> getAllViolation() {
        try {
            return violationDao.getAllViolation();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all Violation: " + e.getMessage(), e);
        }
    }

    @Override
    public Violation getViolationByID(int id) {
        return violationDao.getViolationByID(id);
    }

    @Override
    public List<Violation> getAllViolationByStudent(Student studentId) {
        try {
            return violationDao.getAllViolationByStudent(studentId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all Violation: " + e.getMessage(), e);
        }
    }


    @Override
    public boolean updateViolation(Violation violation) throws RuntimeException{
        boolean result = false;
        try {
            Violation targetViolation = getViolationByID(violation.getId());
            if (targetViolation == null) {
                throw new Exception("Violation to update not found.");
            }
            result = violationDao.updateViolation(violation);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            if (errorMessage != null) {
                throw new RuntimeException(errorMessage);
            } else {
                throw new RuntimeException("An error occurred while updating the Violation information.");
            }
        }
        return result;
    }


    @Override
    public boolean addViolation(Violation violation) throws RuntimeException {
        try {
           return violationDao.addViolation(violation);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Violation: " + e.getMessage(), e);
        }
    }
}