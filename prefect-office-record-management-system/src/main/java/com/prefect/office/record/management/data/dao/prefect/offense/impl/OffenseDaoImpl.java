package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OffenseDaoImpl implements OffenseDao {
    private Connection connection;

    public OffenseDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public boolean saveOffense(Offense offense) {
        String sql = "INSERT INTO offenses (id, student_id, offense_date) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, offense.getId());
            preparedStatement.setString(2, offense.getStudentId());
            preparedStatement.setTimestamp(3, offense.getOffenseDate());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Offense getOffenseById(long id) {
        String sql = "SELECT id, student_id, offense_date FROM offenses WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int offenseId = resultSet.getInt("id");
                String studentId = resultSet.getString("student_id");
                java.sql.Timestamp offenseDate = resultSet.getTimestamp("offense_date");
                return new Offense(offenseId, studentId, offenseDate);
            }
        } catch (SQLException e) {

        }
        return new Offense();
    }

    @Override
    public boolean addOffense(Offense offense) {
        return saveOffense(offense);
    }
}
