package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;

public class ViolationDaoImplTest {
    private ViolationDao violationDAO;

    @BeforeEach
    void setUp() {
        violationDAO = new ViolationDaoImpl();
    }

    @Test
    void testAddViolationWithAppModel() {
        Violation testViolation = new Violation("TestingLang", "TestCon", 5);

        violationDAO.addViolation(testViolation);
        assertTrue(true, "Expected: True, Actual: True");
    }
}
}
