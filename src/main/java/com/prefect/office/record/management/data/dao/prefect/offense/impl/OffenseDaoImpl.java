package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This is an implementation class of the OffenseDao
 */
public class OffenseDaoImpl implements OffenseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffenseDaoImpl.class);

    @Override
    public Offense getOffenseByID(int id) {
        String sql = "SELECT * FROM offense WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idNum = rs.getInt("id");
                    int violationId = rs.getInt("violation_id");
                    String studentId = rs.getString("student_id");
                    Timestamp offense_date = rs.getTimestamp("offense_date");
                    return new Offense(idNum, violationId, studentId, offense_date);
                } else {
                    LOGGER.warn("No offense found with ID: " + id);
                }
            }
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving offense with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense not found.");
        return null;
    }

    @Override
    public boolean updateOffense(Offense offense) {
        String sql = "UPDATE offense SET violation_id = ?, student_id = ?, offense_date = ? WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, offense.getViolationId());
            stmt.setString(2, offense.getStudentId());
            stmt.setTimestamp(3, offense.getOffenseDate());
            stmt.setInt(4, offense.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            LOGGER.warn("Error updating offense with ID " + offense.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Offense> getAllOffenses() {
        List<Offense> offenses = new ArrayList<>();
        String sql = "SELECT * FROM offense";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Offense offense = new Offense();
                offense.setId(resultSet.getInt("id"));
                offense.setViolationId(resultSet.getInt("violation_id"));
                offense.setStudentId(resultSet.getString("student_id"));
                offense.setOffenseDate(resultSet.getTimestamp("offense_date"));
                offenses.add(offense);
            }
            LOGGER.info("Offenses retrieved successfully.");
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving all offenses: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense database is empty.");
        return offenses;

    }
    @Override
    public boolean addOffense(Offense offense) {
        String sql = "INSERT INTO offense (violation_id, student_id, offense_date) VALUES (?, ?, ?)";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, offense.getViolationId());
            stmt.setString(2, offense.getStudentId());
            stmt.setTimestamp(3, offense.getOffenseDate());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
           LOGGER.warn("Error adding offense: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
