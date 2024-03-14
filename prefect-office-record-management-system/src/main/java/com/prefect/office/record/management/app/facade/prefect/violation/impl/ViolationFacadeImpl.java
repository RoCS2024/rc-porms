package com.prefect.office.record.management.app.facade.prefect.violation.impl;

import com.prefect.office.record.management.app.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.app.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.prefect.office.record.management.data.dao.prefect.violation.impl.ViolationDaoImpl;

public class ViolationFacadeImpl implements ViolationFacade {
    private ViolationDao violationDao;

    public ViolationFacadeImpl() {
        this.violationDao = (ViolationDao) new ViolationDaoImpl();
    }

    @Override
    public void addViolation(String violation, String type, int commServHours) {
        Violation newViolation = new Violation(violation, type, commServHours);
        violationDao.addViolation(newViolation);
    }}
