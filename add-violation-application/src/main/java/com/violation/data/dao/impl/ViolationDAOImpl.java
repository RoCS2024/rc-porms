package com.violation.data.dao.impl;

import com.violation.data.connection.ConnectionHelper;
import com.violation.app.model.item.Violation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}