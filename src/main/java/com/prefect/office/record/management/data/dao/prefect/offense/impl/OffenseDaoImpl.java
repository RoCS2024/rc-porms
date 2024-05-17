package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.prefect.office.record.management.data.utils.QueryConstants.*;

/**
 * This is an implementation class of the OffenseDao
 */
public class OffenseDaoImpl implements OffenseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffenseDaoImpl.class);

    @Override
    public Offense getOffenseByID(int id) {

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_OFFENSE_BY_ID_STATEMENT)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    Offense offense = new Offense(id, type, description);

                    return offense;
                } else {
                    LOGGER.warn("No Offense found with ID: " + id);
                }
            }
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving Offense with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense not found.");
        return null;
    }

    @Override
    public Offense getOffenseByName(String offense) {
        try (Connection connection = ConnectionHelper.getConnection()){

            PreparedStatement stmt = connection.prepareStatement(GET_OFFENSE_BY_NAME_STATEMENT);
            stmt.setString(1, "%" + offense + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    Offense newOffense = new Offense(id, type, description);

                    return newOffense;
                } else {
                    LOGGER.warn("No Offense found: " + offense);
                }
            }
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving Offense " + offense + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense not found.");
        return null;
    }

    @Override
    public boolean addOffense(Offense offense) {
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_OFFENSE_STATEMENT)) {
            preparedStatement.setString(1, offense.getType());
            preparedStatement.setString(2, offense.getDescription());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException ex) {
            LOGGER.warn("Error adding offense: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateOffense(Offense offense) {
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(UPDATE_OFFENSE_STATEMENT)) {
            stmt.setString(1, offense.getType());
            stmt.setString(2, offense.getDescription());
            stmt.setInt(3, offense.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            LOGGER.warn("Error updating offense with ID " + offense.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Offense> getAllOffense() {
        List<Offense> offenses = new ArrayList<>();
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_OFFENSE_STATEMENT))   {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Offense offense = new Offense();
                offense.setId(rs.getInt("id"));
                offense.setType(rs.getString("type"));
                offense.setDescription(rs.getString("description"));
                offenses.add(offense);
            }
            LOGGER.info("Offenses retrieved successfully.");
        } catch (Exception e) {
            LOGGER.warn("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Offense database is empty.");
        return offenses;
    }

    @Override
    public List<Offense> getAllOffenseByType(String type) {
        List<Offense> offenses = new ArrayList<>();
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_OFFENSE_BY_TYPE_STATEMENT))   {
            preparedStatement.setString(1, type);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Offense offense = new Offense();
                    offense.setId(rs.getInt("id"));
                    offense.setType(rs.getString("type"));
                    offense.setDescription(rs.getString("description"));
                    offenses.add(offense);
                }
                LOGGER.info("Offenses retrieved successfully.");
            } catch (SQLException ex) {
                LOGGER.warn("Error retrieving all offense by type: " + ex.getMessage());
                ex.printStackTrace();
            }
            LOGGER.debug("Offense database is empty.");
        } catch (SQLException ex) {
            LOGGER.warn("Error preparing statement: " + ex.getMessage());
            ex.printStackTrace();
        }
        return offenses;
    }
}