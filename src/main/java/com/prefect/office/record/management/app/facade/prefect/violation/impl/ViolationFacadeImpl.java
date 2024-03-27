package com.prefect.office.record.management.app.facade.prefect.violation.impl;

import com.prefect.office.record.management.app.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.app.model.violation.Violation;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.prefect.office.record.management.data.dao.prefect.violation.impl.ViolationDaoImpl;
import oracle.jdbc.proxy.annotation.Pre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ViolationFacadeImpl implements ViolationFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViolationFacade.class);
    Connection c = ConnectionHelper.getConnection();
    private ViolationDao violationDAO;

    public ViolationFacadeImpl() {
        this.violationDAO = new ViolationDaoImpl();
    }

    @Override
    public void addViolation(String violation, String type, int commServHours) {
        try {
            Violation newViolation = new Violation(violation, type, commServHours);
            violationDAO.addViolation(newViolation);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add violation: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Violation> getAllViolation() {
        List<Violation> violations = new ArrayList<>();
        try {
            String sql = "SELECT * FROM violation";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Violation violation = new Violation();
                violation.setId(rs.getInt("id"));
                violation.setViolation(rs.getString("violation"));
                violation.setType(rs.getString("type"));
                violation.setCommServHours(rs.getInt("comm_serv_hours"));
                violations.add(violation);
            }
            LOGGER.info("Employee retrieved successfully.");
        } catch (Exception e) {
            LOGGER.warn("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Employee database is empty.");
        return violations;
    }
}