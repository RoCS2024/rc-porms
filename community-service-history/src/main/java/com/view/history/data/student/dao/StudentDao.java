package com.view.history.data.student.dao;

import com.view.history.app.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    Student saveStudent(Student student) throws SQLException;

    List<Student> getAllStudent() throws SQLException;

    Student getStudentById(long id) throws SQLException;

    Student getStudentById(String studentId);

    List<Student> getAllStudents();
}

