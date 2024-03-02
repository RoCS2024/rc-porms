package com.view.history.app.facade.student.impl;

import com.view.history.app.facade.student.StudentFacade;
import com.view.history.app.model.Student;
import com.view.history.data.student.dao.StudentDao;
import com.view.history.data.student.dao.impl.StudentDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentFacadeImpl implements StudentFacade {

    private StudentDao studentDao;

    public StudentFacadeImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    public StudentFacadeImpl(Student student) {
    }


    @Override
    public Student getStudentById(String studentId) throws SQLException {
        return null;
    }

    @Override
    public List<Student> getStudentById() {
        return null;
    }
}
