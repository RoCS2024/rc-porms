package com.add.offense.data.dao.student.impl;

import com.add.offense.app.model.student.Student;
import com.add.offense.data.dao.student.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDao {

    private static final String UPDATE_STUDENT_STATEMENT = "";
    private static final String DELETE_STUDENT_BY_ID_STATEMENT = "";
    private static final String GET_STUDENT_BY_ID_STATEMENT = "";
    public static final String GET_ALL_STUDENT_STATEMENT = "";
    private static final String INSERT_QUERY = "";
    private Connection con;


    @Override
    public void insertStudent(Student student) {
        try (PreparedStatement statement = con.prepareStatement(INSERT_QUERY)) {

            statement.setString(1, student.getStudentId());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getFirstName());
            statement.setString(4, student.getMiddleName());
            statement.setString(5, student.getSex());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getContactNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            PreparedStatement statement = con.prepareStatement(UPDATE_STUDENT_STATEMENT);

            statement.setString(1, student.getLastName());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getMiddleName());
            statement.setString(4, student.getSex());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getContactNumber());
            statement.setString(7, student.getStudentId());
            int result = statement.executeUpdate();
            return result == 1;
        } catch (Exception e) {
        }
        return false;

    }

    @Override
    public boolean deleteStudent(String studentId) {
        try {
            PreparedStatement statement = con.prepareStatement(DELETE_STUDENT_BY_ID_STATEMENT);

            statement.setString(1, studentId);
            int result = statement.executeUpdate();
            return result == 1;
        } catch (Exception e) {

        }
        return false;

    }

    @Override
    public Student getStudentById(String studentId) {
        try {
            PreparedStatement statement = con.prepareStatement(GET_STUDENT_BY_ID_STATEMENT);
            ResultSet rs = statement.executeQuery();
            return rs.next() ? getStudentById(String.valueOf(rs)) : null;
        } catch (Exception e) {
        }
        return null;
    }


    @Override
    public List<Student> getAllStudents() {
        try {
            PreparedStatement statement = con.prepareStatement(GET_ALL_STUDENT_STATEMENT);
            ResultSet rs = statement.executeQuery();
            List<Student> studentList = new ArrayList<>();

            while (rs.next()) {
                studentList.add(setStudent(rs));
            }
            return studentList;

        } catch (Exception e) {

        }
        return null;
    }


    private Student setStudent(ResultSet rs) {
        try {
            Student student = new Student();
            student.setStudentId(rs.getString("student_id"));
            student.setLastName(rs.getString("last_name"));
            student.setFirstName(rs.getString("first_name"));
            student.setMiddleName(rs.getString("middle_name"));
            student.setSex(rs.getString("sex"));
            student.setAddress(rs.getString("address"));
            student.setContactNumber(rs.getString("contact_number"));
            return student;

        } catch (Exception e) {

        }
        return null;
    }

    private String buildParameters(List<String> ids) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (String id : ids) {
            sb.append("?, ");
        }

        //delete the last character added which is
            String params = sb.deleteCharAt(sb.length() - 1).toString();

        //delete the second to the last character added which is ","
            params = sb.deleteCharAt(sb.length() - 1).toString();

            params = params + ")";

            return params;
        }
    }


