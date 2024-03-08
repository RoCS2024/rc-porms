package com.prefect.office.record.management.data.dao.prefect.communityservice.impl;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;

import java.sql.*;

public class CommunityServiceDaoImpl implements CommunityServiceDao {
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
    public boolean renderCs(CommunityService cs) {
        String sql = "UPDATE comm_serv_rendered SET student_id = ?, date_rendered = ?, hours_rendered = ? WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cs.getStudent_id());
            stmt.setTimestamp(4, cs.getDate_rendered());
            stmt.setInt(2, cs.getHours_rendered());
            stmt.setInt(5, cs.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("Error updating Community Service with ID " + cs.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
