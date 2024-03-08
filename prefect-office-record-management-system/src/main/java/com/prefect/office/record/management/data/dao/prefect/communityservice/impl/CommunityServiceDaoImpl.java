package com.prefect.office.record.management.data.dao.prefect.communityservice.impl;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommunityServiceDaoImpl implements CommunityServiceDao {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return communityServices;
    }

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
                    System.err.println("No Community Service found with ID: " + id);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error retrieving Community Service with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean renderCs(CommunityService cs) throws SQLException {
        String sql = "UPDATE comm_serv_rendered SET student_id = ?, date_rendered = ?, hours_rendered = ? WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cs.getStudent_id());
            stmt.setTimestamp(2, cs.getDate_rendered());
            stmt.setInt(3, cs.getHours_rendered());
            stmt.setInt(4, cs.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
