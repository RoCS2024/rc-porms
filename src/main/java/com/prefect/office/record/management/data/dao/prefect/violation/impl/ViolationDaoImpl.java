package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This is an implementation class of the ViolationDao
 */
public class ViolationDaoImpl implements ViolationDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViolationDaoImpl.class);

    @Override
    public Violation getViolationByID(int id) {
        String sql = "SELECT * FROM violation WHERE id = ?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String violationName = rs.getString("violation");
                    String type = rs.getString("type");
                    int commServHours = rs.getInt("comm_serv_hours");
                    return new Violation(violationName, type, commServHours);
                } else {
                    LOGGER.warn("No Violation found with ID: " + id);
                }
            }
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving Violation with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Violation not found.");
        return null;
    }

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
    public boolean updateViolation(Violation violation) {
        String sql = "UPDATE violation SET violation = ?, type = ?, comm_serv_hours = ? WHERE id = ?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, violation.getViolation());
            stmt.setString(2, violation.getType());
            stmt.setInt(3, violation.getCommServHours());
            stmt.setInt(4, violation.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            LOGGER.warn("Error updating violation with ID " + violation.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
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