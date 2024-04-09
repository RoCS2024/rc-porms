package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.prefect.office.record.management.data.utils.QueryConstants.*;
public class ViolationDaoImpl implements ViolationDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViolationDaoImpl.class);
    Connection c = ConnectionHelper.getConnection();
    public ViolationDaoImpl() {
    }

    @Override
    public void addViolation(Violation violation) {
        try (PreparedStatement stmt = c.prepareStatement(ADD_VIOLATION_STATEMENT)) {
            stmt.setString(1, violation.getViolation());
            stmt.setString(2, violation.getType());
            stmt.setInt(3, violation.getCommServHours());

            int result = stmt.executeUpdate();

            if (result == 1) {
                LOGGER.info("Violation added successfully.");
            } else {
                LOGGER.debug("Adding violation failed.");
            }
        } catch (SQLException e) {
            LOGGER.error("An SQL Exception occurred: " + e.getMessage());
        }
    }

    @Override
    public List<Violation> getAllViolation() {
        List<Violation> violations = new ArrayList<>();
        try ( PreparedStatement stmt = c.prepareStatement(GET_ALL_VIOLATION_STATEMENT);
              ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Violation violation = new Violation();
                violation.setId(rs.getInt("id"));
                violation.setViolation(rs.getString("violation"));
                violation.setType(rs.getString("type"));
                violation.setCommServHours(rs.getInt("comm_serv_hours"));
                violations.add(violation);
            }
            LOGGER.info("Violations retrieved successfully.");
        } catch (Exception e) {
            LOGGER.warn("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Violation database is empty.");
        return violations;
    }
}