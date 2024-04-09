package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.prefect.office.record.management.data.utils.QueryConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.prefect.office.record.management.data.utils.QueryConstants.*;

public class OffenseDaoImpl implements OffenseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffenseDaoImpl.class);
    Connection c = ConnectionHelper.getConnection();
    public OffenseDaoImpl() {
    }
    @Override
    public Offense getOffenseByID(int id) {
        try (Connection c = new ConnectionHelper().getConnection()){
            PreparedStatement stmt = c.prepareStatement(QueryConstants.GET_OFFENSE_BY_ID_STATEMENT);
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
        } catch (Exception ex) {
            LOGGER.warn("Error retrieving offense with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense not found.");
        return null;
    }

    @Override
    public boolean updateOffense(Offense offense) {
        try (Connection c = new ConnectionHelper().getConnection()){
            PreparedStatement stmt = c.prepareStatement(QueryConstants.UPDATE_OFFENSE_STATEMENT);
            ResultSet rs= stmt.executeQuery();
            stmt.setInt(1, offense.getViolationId());
            stmt.setString(2, offense.getStudentId());
            stmt.setTimestamp(3, offense.getOffenseDate());
            stmt.setInt(4, offense.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception ex) {
            LOGGER.warn("Error updating offense with ID " + offense.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Offense> getAllOffenses() {
        List<Offense> offenses = new ArrayList<>();
        try (Connection c = new ConnectionHelper().getConnection()){
            PreparedStatement stmt = c.prepareStatement(QueryConstants.GET_ALL_OFFENSES_STATEMENT);
            ResultSet rs= stmt.executeQuery();

            while (rs.next()) {
                Offense offense = new Offense();
                offense.setId(rs.getInt("id"));
                offense.setViolationId(rs.getInt("violation_id"));
                offense.setStudentId(rs.getString("student_id"));
                offense.setOffenseDate(rs.getTimestamp("offense_date"));
                offenses.add(offense);
            }
            LOGGER.info("Offenses retrieved successfully.");
        } catch (Exception ex) {
            LOGGER.warn("Error retrieving all offenses: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense database is empty.");
        return offenses;

    }

    @Override
    public boolean addOffense(Offense offense) {
        try (Connection c = new ConnectionHelper().getConnection()){
            PreparedStatement stmt = c.prepareStatement(QueryConstants.ADD_OFFENSE_STATEMENT);
            ResultSet rs= stmt.executeQuery();

            stmt.setInt(1, offense.getViolationId());
            stmt.setString(2, offense.getStudentId());
            stmt.setTimestamp(3, offense.getOffenseDate());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception ex) {
           LOGGER.warn("Error adding offense: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
