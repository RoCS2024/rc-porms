package com.prefect.office.record.management.appl.facade.prefect.violation.impl;

import com.prefect.office.record.management.appl.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.prefect.office.record.management.data.dao.prefect.violation.impl.ViolationDaoImpl;

import java.util.List;

/**
 * This is an implementation class of the ViolationFacade
 */
public class ViolationFacadeImpl implements ViolationFacade {
    private ViolationDao violationDAO;

    /**
     * This is a constructor for new ViolationFacadeImpl object
     * This initializes the ViolationDao
     */
    public ViolationFacadeImpl(ViolationDao violationDao) { this.violationDAO = violationDao;}

    @Override
    public void addViolation(String violation, String type, int commServHours) throws RuntimeException{
        try {
            Violation newViolation = new Violation(violation, type, commServHours);
            violationDAO.addViolation(newViolation);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add violation: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateViolation(Violation violation) throws RuntimeException{
        boolean result = false;
        try {
            Violation targetViolation = getViolationByID(violation.getId());
            if (targetViolation == null) {
                throw new Exception("Violation to update not found. ");
            }
            result = violationDAO.updateViolation(violation);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public Violation getViolationByID(int id) {
        return violationDAO.getViolationByID(id);
    }

    @Override
    public Violation getViolationByName(String violation) {
        return violationDAO.getViolationByName(violation);
    }

    @Override
    public List<Violation> getAllViolation() {
        return violationDAO.getAllViolation();
    }

    @Override
    public List<Violation> getAllViolationByType(String type) {
        try {
            return violationDAO.getAllViolationByType(type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all violation by tpe: " + e.getMessage(), e);
        }
    }
}