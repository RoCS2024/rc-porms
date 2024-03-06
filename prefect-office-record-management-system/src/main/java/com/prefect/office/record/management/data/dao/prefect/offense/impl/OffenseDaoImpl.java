package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OffenseDaoImpl implements OffenseDao {
    private Connection connection;

    public OffenseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean saveOffense(Offense offense) {
        return false;
    }

    @Override
    public Offense getOffenseById(long id) {
        return null;
    }

    @Override
    public Object getOffenseById() {
        return null;
    }

    @Override
    public boolean addOffense(Offense offense) {
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

}
