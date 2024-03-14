package com.violation.data.dao.impl;

import com.violation.app.facade.violation.impl.ViolationFacade;
import com.violation.app.facade.violation.impl.ViolationFacadeImpl;
import com.violation.app.model.item.Violation;


public class ViolationDaoImplTest {

    private ViolationFacade violationFacade;
    private ViolationDao violationDaoMock;

    @BeforeEach
    public void setUp() {
        violationDaoMock = mock(ViolationDao.class);
        violationFacade = new ViolationFacadeImpl();
    }

    @Test
    public void saveViolation() {
        Violation violation = new Violation();
        when(violationFacade.saveViolation(violation)).thenReturn(true);

        assertTrue(violationFacade.saveViolation(violation));
    }

    @Test
    public void getViolationById() {

        Violation expectedViolation = new Violation();
        when(violationDaoMock.getViolationById()).thenReturn(expectedViolation);

        Violation retrievedViolation= violationFacade.getViolationById();

        assertEquals(expectedViolation, retrievedViolation);
    }
}
