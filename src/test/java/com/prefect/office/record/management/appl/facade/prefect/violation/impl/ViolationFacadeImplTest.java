package com.prefect.office.record.management.appl.facade.prefect.violation.impl;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.mockito.Mockito.*;

class ViolationFacadeImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ViolationFacadeImplTest.class);

    @InjectMocks
    private ViolationFacadeImpl violationFacade;

    @Mock
    private ViolationDao violationDao;

    @Mock
    private List<Violation> violationList;

    @Mock
    private Violation violation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void testAddViolation() {
        try {
            String violationName = "CUTTING";
            String violationType = "SUPER INTENSE!";
            int commServHours = 10;

            violationFacade.addViolation(violationName, violationType, commServHours);

            verify(violationDao).addViolation(any(Violation.class));
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateViolation() {
        try {
            when(violationDao.getViolationByID(violation.getId())).thenReturn(violation);
            when(violationDao.updateViolation(violation)).thenReturn(true);

            boolean result = violationFacade.updateViolation(violation);

            assert(result == true);

            assert(violationFacade.getViolationByID(1).equals(violation));

            verify(violationDao).updateViolation(violation);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }

    @Test
    public void testGetViolationById() {
        when(violationDao.getViolationByID(1)).thenReturn(violation);
        Violation expectedViolation = violationFacade.getViolationByID(1);

        assert(expectedViolation.equals(violation));

        verify(violationDao).getViolationByID(1);
    }

    @Test
    public void testGetAllViolation() {
        when(violationDao.getAllViolation()).thenReturn(violationList);

        List<Violation> expectedList = violationFacade.getAllViolation();

        assert (expectedList.equals(violationList));
        verify(violationDao).getAllViolation();
    }

    @Test
    public void testGetViolationByName() {
        when(violationDao.getViolationByName("fighting")).thenReturn(violation);
        Violation expectedViolation = violationFacade.getViolationByName("fighting");

        assert(expectedViolation.equals(violation));

        verify(violationDao).getViolationByName("fighting");
    }

    @Test
    public void testGetAllViolationByType() {
        String major = "Major";

        when(violationDao.getAllViolationByType(major)).thenReturn(violationList);

        List<Violation> expectedList = violationFacade.getAllViolationByType(major);

        assert (expectedList.equals(violationList));
        verify(violationDao).getAllViolationByType(major);
    }
}
