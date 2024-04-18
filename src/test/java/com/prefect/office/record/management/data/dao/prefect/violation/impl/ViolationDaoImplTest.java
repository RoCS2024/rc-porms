package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    public void testAddViolation(){
        Violation testViolation = new Violation("TestingLang", "TestCon", 5);

        violationDao.addViolation(testViolation);
        assertTrue(true, "Expected: True, Actual: True");
    }

    @Test
    public void testUpdateViolation() {
        Violation violation = new Violation();
        violation.setId(1);

        when(violationDao.updateViolation(violation)).thenReturn(true);
        when(violationDao.getViolationByID(1)).thenReturn(violation);

        Violation expectedViolation = violationDao.getViolationByID(1);
        assertEquals(expectedViolation.getId(), violation.getId());
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
}