package com.view.history.app.facade.student;

import com.view.history.app.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentFacade {
    Student getStudentById(String studentId) throws SQLException;

    List<Student> getStudentById();
}
