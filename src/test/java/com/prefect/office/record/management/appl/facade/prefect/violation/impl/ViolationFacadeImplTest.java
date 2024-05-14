package com.prefect.office.record.management.appl.facade.prefect.violation.impl;

import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.student.information.management.appl.model.student.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Mock
    private Violation addViolation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        violationFacade = new ViolationFacadeImpl(violationDao);
        violation.setId(1);
        addViolation.setId(2);
        when(violationDao.getAllViolation()).thenReturn(violationList);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }
    @Test
    public void testGetAllOffenses() {
        List expectedList = violationFacade.getAllViolation();

        assert(expectedList.equals(violationList));
        verify(violationDao).getAllViolation();
    }

    @Test
    public void testGetOffenseById() {
        when(violationDao.getViolationByID(1)).thenReturn(violation);
        Violation expectedViolation = violationFacade.getViolationByID(1);

        assert(expectedViolation.equals(violation));

        verify(violationDao).getViolationByID(1);
    }

    @Test
    public void testAddOffense() {
        try {
            when(violationDao.getViolationByID(addViolation.getId())).thenReturn(null);
            when(violationDao.addViolation(addViolation)).thenReturn(true);

            boolean result = violationFacade.addViolation(addViolation);

            assert(result == true);

            assert(violationFacade.getViolationByID(2) == null);

            verify(violationDao).addViolation(addViolation);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }

    }

    @Test
    public void testUpdateOffense() {
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
    public void testGetAllOffenseByStudentId() {
        Student student1 = new Student();
        student1.setStudentId("CT21-0001");
        when(violationDao.getAllViolationByStudent(student1)).thenReturn(violationList);

        List<Violation> expectedList = violationFacade.getAllViolationByStudent(student1);

        assertEquals(expectedList, violationList);
        verify(violationDao).getAllViolationByStudent(student1);
    }
}
