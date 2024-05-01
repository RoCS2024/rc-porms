package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.prefect.office.record.management.data.utils.QueryConstants.*;

/**
 * This is an implementation class of the ViolationDao
 */
public class ViolationDaoImpl implements ViolationDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViolationDaoImpl.class);


    @Override
    public Violation getViolationByID(int id) {

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_BY_ID_VIOLATION_STATEMENT)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String violationName = rs.getString("violation");
                    String type = rs.getString("type");
                    int commServHours = rs.getInt("comm_serv_hours");
                    Violation violation = new Violation(violationName, type, commServHours);
                    violation.setId(id);

                    return violation;
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
    public void addViolation(Violation violation){
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_VIOLATION_STATEMENT)) {
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
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(UPDATE_VIOLATION_STATEMENT)) {
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
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_VIOLATION_STATEMENT))   {
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