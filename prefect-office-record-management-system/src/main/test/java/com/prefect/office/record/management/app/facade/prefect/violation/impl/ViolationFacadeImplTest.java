package com.prefect.office.record.management.app.facade.prefect.violation.impl;

import com.prefect.office.record.management.app.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.app.model.violation.Violation;

public class ViolationFacadeImplTest {
    private ViolationFacade violationFacade;

    @BeforeEach
    public void setUp() {
        violationFacade = new violationDaoImpl();
        studentIds = new ArrayList<>();
        studentIds.add("CT22-2132");
        studentIds.add("CT23-2132");
    }

    @Test
    public void saveViolation() {
        Violation violation = new violation();
        violation.setViolationId(11);
        violation.setStudentId("Ct23-2132");
        assertEquals(violation, violation);
    }

    @Test
    public void getViolationById() {
        Violation expectedViolation = new Violation();
        expectedViolation.setId(11);
        when(violationDaoMock.getViolationById(11)).thenReturn(expectedViolation);
        Violation retrievedViolation = violationFacade.getViolationById(11);
        assertEquals(expectedViolation, retrievedViolation);
    }
}
