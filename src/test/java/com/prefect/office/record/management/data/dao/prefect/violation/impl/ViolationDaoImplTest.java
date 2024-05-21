package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.student.information.management.appl.model.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViolationDaoImplTest {
    private ViolationDao violationDao;
    private List<Violation> violations;

    @BeforeEach
    public void setUp() {
        violations = new ArrayList<>();
        Violation violation1 = new Violation();
        Violation violation2 = new Violation();
        violations.add(violation1);
        violations.add(violation2);

        violationDao = mock(ViolationDao.class);
    }
    @Test
    public void testGetAllViolation() {
        when(violationDao.getAllViolation()).thenReturn(violations);
        List<Violation> violationList = violationDao.getAllViolation();
        assertEquals(violationList.size(), 2);
    }

    @Test
    public void testGetViolationById() {
        Violation violation1 = new Violation();
        violation1.setId(1);

        when(violationDao.getViolationByID(1)).thenReturn(violation1);

        Violation expectedViolation = violationDao.getViolationByID(1);

        assertEquals(expectedViolation, violation1);
        assertEquals(expectedViolation.getId(), violation1.getId());
    }

    @Test
    public void testAddViolation() {
        Violation violation = new Violation();
        violation.setId(1);

        when(violationDao.addViolation(violation)).thenReturn(true);
        when(violationDao.getViolationByID(1)).thenReturn(violation);

        Violation expectedViolation = violationDao.getViolationByID(1);
        assertEquals(expectedViolation.getId(), violation.getId());
    }
    @Test
    public void testUpdateViolation() {
        Violation violation = new Violation();
        violation.setId(1);

        when(violationDao.addViolation(violation)).thenReturn(true);
        when(violationDao.updateViolation(violation)).thenReturn(true);
        when(violationDao.getViolationByID(1)).thenReturn(violation);

        Violation expectedViolation = violationDao.getViolationByID(1);
        assertEquals(expectedViolation.getId(), violation.getId());
    }

    @Test
    public void testGetAllViolationByStudentId() {
        Student student1 = new Student();
        student1.setStudentId("CT21-0001");

        Violation violation1 = new Violation();
        violation1.setStudent(student1);

        when(violationDao.getAllViolationByStudent(student1)).thenReturn(violations);
        List<Violation> violationList = violationDao.getAllViolationByStudent(student1);
        assertEquals(violationList.size(), 2);
    }
}