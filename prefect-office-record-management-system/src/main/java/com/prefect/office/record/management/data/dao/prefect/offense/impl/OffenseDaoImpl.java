package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OffenseDaoImpl implements OffenseDao {
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
                    Timestamp offenseDate = rs.getTimestamp("offense_date");
                    return new Offense(idNum, violationId, studentId, offenseDate);
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("no id found in offense " + id, ex);
        }
    }

    @Override
    public boolean saveOffense(Offense offense) {
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
            throw new RuntimeException("no id found in offense " + offense.getId(), ex);
        }
    }
    @Override
    public Offense getOffenseById(long id) {
        return getOffenseByID((int) id);
    }
}
