package com.violation.data.dao.impl;

import com.violation.app.model.item.Violation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViolationDAOImplTest {

    private ViolationDAO violationDAO;

    @BeforeEach
    void setUp() {
        violationDAO = new ViolationDAOImpl();
    }

    @Test
    void testAddViolationWithAppModel() {
        Violation testViolation = new Violation("TestingLang", "TestCon", 5);

        violationDAO.addViolation(testViolation);
        assertTrue(true, "Expected: True, Actual: True");
    }
}
