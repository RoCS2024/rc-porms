package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.app.model.violation.Violation;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ViolationDaoImpl implements ViolationDao {

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