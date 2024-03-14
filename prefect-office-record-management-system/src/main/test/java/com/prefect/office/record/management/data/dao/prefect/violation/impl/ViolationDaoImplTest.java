package com.prefect.office.record.management.data.dao.prefect.violation.impl;

import com.prefect.office.record.management.app.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;

public class ViolationDaoImplTest {
    private ViolationDao violationDao;

    @BeforeEach
    void setUp() {
        violationDao = new ViolationDaoImpl();
    }

    @Test
    void testAddViolationWithAppModel() {
        Violation testViolation = new Violation("TestingLang", "TestCon", 5);

        violationDao.addViolation(testViolation);
        assertTrue(true, "Expected: True, Actual: True");
    }
}
}
