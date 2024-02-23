package com.violation.app.facade.violation.impl;

import com.violation.data.dao.impl.ViolationDAO;
import com.violation.app.model.item.Violation;
import com.violation.data.dao.impl.ViolationDAOImpl;

import java.util.List;

public class ViolationFacadeImpl implements ViolationFacade {
    private ViolationDAO violationDAO;

    public ViolationFacadeImpl() {
        this.violationDAO = new ViolationDAOImpl();
    }

    @Override
    public void addViolation(String violation, String type, int commServHours) {
        Violation newViolation = new Violation(violation, type, commServHours);
        violationDAO.addViolation(newViolation);
    }

    @Override
    public void updateViolation(int id, String violation, String type, int commServHours) {
        Violation updatedViolation = new Violation(violation, type, commServHours);
        updatedViolation.setId(id);
        violationDAO.updateViolation(updatedViolation);
    }

    @Override
    public List<Violation> getAllViolations() {
        return violationDAO.getAllViolations();
    }
}