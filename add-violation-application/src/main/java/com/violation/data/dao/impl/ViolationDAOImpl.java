package com.violation.data.dao.impl;

import com.violation.data.connection.ConnectionHelper;
import com.violation.app.model.item.Violation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViolationDAOImpl implements ViolationDAO {

    @Override
    public void addViolation(Violation violation) {
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO violation(violation, type, comm_serv_hours) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, violation.getViolation());
            preparedStatement.setString(2, violation.getType());
            preparedStatement.setInt(3, violation.getCommServHours());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateViolation(Violation violation) {
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE violation SET violation = ?, type = ?, comm_serv_hours = ? WHERE id = ?")) {
            preparedStatement.setString(1, violation.getViolation());
            preparedStatement.setString(2, violation.getType());
            preparedStatement.setInt(3, violation.getCommServHours());
            preparedStatement.setInt(4, violation.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Violation> getAllViolations() {
        return null;
    }
}
