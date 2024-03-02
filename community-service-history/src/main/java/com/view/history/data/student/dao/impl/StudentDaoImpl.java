package com.view.history.data.student.dao.impl;

import com.view.history.app.model.Student;
import com.view.history.data.connection.ConnectionHelper;
import com.view.history.data.student.dao.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public abstract class StudentDaoImpl implements StudentDao {

    @Override
    public Student getStudentById(String studentId) {
        String query = "SELECT * FROM student WHERE student_id = ?";
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

    private Student extractStudentFromResultSet(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setStudentId(resultSet.getString("student_id"));
        student.setLastName(resultSet.getString("last_name"));
        student.setFirstName(resultSet.getString("first_name"));
        student.setMiddleName(resultSet.getString("middle_name"));
        student.setSex(resultSet.getString("sex"));
        student.setBirthday(String.valueOf(resultSet.getTimestamp("birthday")));
        student.setReligion(resultSet.getString("religion"));
        student.setEmail(resultSet.getString("email"));
        student.setAddress(resultSet.getString("address"));
        student.setContactNumber(resultSet.getString("contact_number"));

        return student;
    }

}
