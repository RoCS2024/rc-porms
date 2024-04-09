package com.prefect.office.record.management.data.dao.prefect.communityservice.impl;

import com.prefect.office.record.management.appl.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import com.prefect.office.record.management.data.utils.QueryConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.prefect.office.record.management.data.utils.QueryConstants.*;

public class CommunityServiceDaoImpl implements CommunityServiceDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommunityServiceDaoImpl.class);
    Connection c = ConnectionHelper.getConnection();
    public CommunityServiceDaoImpl() {
    }
    @Override
    public List<CommunityService> getAllCs() {
        List<CommunityService> communityServices = new ArrayList<>();
        try (Connection c = new ConnectionHelper().getConnection()){
            PreparedStatement stmt = c.prepareStatement(QueryConstants.GET_ALL_CS_STATEMENT);
            ResultSet rs= stmt.executeQuery();

            while (rs.next()) {
                CommunityService communityService = new CommunityService();
                communityService.setId(rs.getInt("id"));
                communityService.setStudent_id(rs.getString("student_id"));
                communityService.setDate_rendered(rs.getTimestamp("date_rendered"));
                communityService.setHours_rendered(rs.getInt("hours_rendered"));
                communityServices.add(communityService);
            }
            LOGGER.info("Community Service retrieved successfully.");
        } catch (Exception ex) {
            LOGGER.warn("Error retrieving all community services: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Community Service database is empty.");
        return communityServices;
    }

        @Override
        public CommunityService getCsById(int id) {
            try (Connection c = new ConnectionHelper().getConnection()){
                PreparedStatement stmt = c.prepareStatement(QueryConstants.GET_CS_BY_ID_STATEMENT);
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
            } catch (Exception ex) {
                LOGGER.warn("Error retrieving Community Service with ID " + id + ": " + ex.getMessage());
                ex.printStackTrace();
            }
            LOGGER.debug("Community Service not found.");
            return null;
        }

    @Override
    public boolean renderCs(CommunityService cs) throws SQLException {
        try (Connection c = new ConnectionHelper().getConnection()){
            PreparedStatement stmt = c.prepareStatement(QueryConstants.RENDER_CS_STATEMENT);
            ResultSet rs= stmt.executeQuery();

            stmt.setString(1, cs.getStudent_id());
            stmt.setTimestamp(2, cs.getDate_rendered());
            stmt.setInt(3, cs.getHours_rendered());
            stmt.setInt(4, cs.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception ex) {
            LOGGER.warn("Error rendering Community Service: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}


