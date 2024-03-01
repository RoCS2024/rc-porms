package com.add.offense.data.dao.student;

import com.add.offense.app.model.student.Student;

import java.util.List;

public interface StudentDao {
    void insertStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(String studentId);
    Student getStudentById(String studentId);
    List<Student> getAllStudents();
}