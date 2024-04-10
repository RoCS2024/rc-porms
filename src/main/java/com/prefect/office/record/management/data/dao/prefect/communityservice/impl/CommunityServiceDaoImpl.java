package com.prefect.office.record.management.data.dao.prefect.communityservice.impl;

import com.prefect.office.record.management.appl.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Implements the CommunityServiceDao interface to interact with the database for managing community service records.
 */
public class CommunityServiceDaoImpl implements CommunityServiceDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommunityServiceDaoImpl.class);

    /**
     * Retrieves all community service records from the database.
     *
     * @return A list of all community service records.
     */
    @Override
    public List<CommunityService> getAllCs() {
        List<CommunityService> communityServices = new ArrayList<>();
        String sql = "SELECT * FROM comm_serv_rendered";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CommunityService communityService = new CommunityService();
                communityService.setId(resultSet.getInt("id"));
                communityService.setStudent_id(resultSet.getString("student_id"));
                communityService.setDate_rendered(resultSet.getTimestamp("date_rendered"));
                communityService.setHours_rendered(resultSet.getInt("hours_rendered"));
                communityServices.add(communityService);
            }
            LOGGER.info("Community Service retrieved successfully.");
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving all community services: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Community Service database is empty.");
        return communityServices;
    }

    /**
     * Retrieves a specific community service record by its ID from the database.
     *
     * @param id The ID of the community service record to retrieve.
     * @return The community service record corresponding to the given ID.
     */
    @Override
    public CommunityService getCsById(int id) {
        String sql = "SELECT * FROM comm_serv_rendered WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idNum = rs.getInt("id");
                    String student_id = rs.getString("student_id");
                    Timestamp date_rendered = rs.getTimestamp("date_rendered");
                    int hours_rendered = rs.getInt("hours_rendered");
                    return new CommunityService(idNum, student_id, date_rendered, hours_rendered);
                } else {
                    LOGGER.info("No Community Service found with ID: " + id);
                }
            }
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving Community Service with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Community Service not found.");
        return null;
    }


    /**
     *      * Records a new community service entry into the database.
     *
     * @param cs The community service record to insert.
     * @return True if the insertion is successful, false otherwise.
     * @throws SQLException If an SQL exception occurs during the insertion process.
     */
    @Override
    public boolean renderCs(CommunityService cs) throws SQLException {
        String sql = "INSERT INTO comm_serv_rendered (student_id, date_rendered, hours_rendered) VALUES (?, ?, ?)";

        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cs.getStudent_id());
            stmt.setTimestamp(2, cs.getDate_rendered());
            stmt.setInt(3, cs.getHours_rendered());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            LOGGER.warn("Error rendering Community Service: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
