package com.view.history.data.communityservicehistory.dao.impl;

import com.view.history.app.model.CommunityServiceHistory;
import com.view.history.data.communityservicehistory.dao.CommunityServiceHistoryDao;
import com.view.history.data.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CommunityServiceHistoryDaoImpl implements CommunityServiceHistoryDao {

    @Override
    public CommunityServiceHistory getId(String studentId) {
        String query = "SELECT * FROM CommunityServiceHistory WHERE Id = ?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, studentId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractStudentFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CommunityServiceHistory extractStudentFromResultSet(ResultSet resultSet) throws SQLException {
        CommunityServiceHistory CommunityServiceHistory = new CommunityServiceHistory();
        CommunityServiceHistory.setId(resultSet.getString("id"));
        CommunityServiceHistory.setStudentId(resultSet.getString("Student_Id"));
        CommunityServiceHistory.setDateRendered(resultSet.getString("Date_Rendered"));
        CommunityServiceHistory.setHoursRendered(resultSet.getString("Hours_Rendered"));


        return CommunityServiceHistory;
    }

    public abstract Connection getConnection();
}
