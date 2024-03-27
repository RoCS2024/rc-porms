package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.app.model.violation.Violation;
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

public class ViolationDaoImpl implements ViolationDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ViolationDaoImpl.class);

    @Override
    public void addViolation(Violation violation) {
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO violation(violation, type, comm_serv_hours) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, violation.getViolation());
            preparedStatement.setString(2, violation.getType());
            preparedStatement.setInt(3, violation.getCommServHours());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.warn("Error adding violation: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Adding violation failed.");
    }

    @Override
    public List<Violation> getAllViolation() {
        List<Violation> violations = new ArrayList<>();
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM violation"))   {
            ResultSet rs = preparedStatement.executeQuery();

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