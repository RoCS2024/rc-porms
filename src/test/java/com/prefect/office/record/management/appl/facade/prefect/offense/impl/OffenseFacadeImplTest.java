package com.prefect.office.record.management.appl.facade.prefect.offense.impl;

import com.student.information.management.appl.facade.student.impl.StudentFacadeImpl;
import com.student.information.management.appl.model.student.Student;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
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

class OffenseFacadeImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(OffenseFacadeImplTest.class);

    @InjectMocks
    private OffenseFacadeImpl offenseFacade;

    @Mock
    private OffenseDao offenseDao;

    @Mock
    private List<Offense> offenseList;

    @Mock
    private Offense offense;

    @Mock
    private Student studentId;

    @Mock
    private StudentFacadeImpl studentFacade;

    @Mock
    private List<Offense> studentOffenseList;

    @Mock
    private Offense addOffense;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        offenseFacade = new OffenseFacadeImpl(offenseDao);
        offense.setId(1);
        addOffense.setId(2);
        when(offenseDao.getAllOffenses()).thenReturn(offenseList);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }
    @Test
    public void testGetAllOffenses() {
        List expectedList = offenseFacade.getAllOffenses();

        assert(expectedList.equals(offenseList));
        verify(offenseDao).getAllOffenses();
    }

//    @Test
//    public void testGetAllOffensesByStudentId() {
//        studentId = studentFacade.getStudentById("Ct21-0048");
//        List expectedList = offenseFacade.getAllOffenseByStudentId(studentId);
//
//        studentOffenseList = offenseFacade.getAllOffenseByStudentId(studentId);
//
//        assert(expectedList.equals(studentOffenseList));
//        verify(offenseDao).getAllOffenseByStudentId(studentId);
//    }

    @Test
    public void testGetOffenseById() {
        when(offenseDao.getOffenseByID(1)).thenReturn(offense);
        Offense expectedOffense = offenseFacade.getOffenseByID(1);

        assert(expectedOffense.equals(offense));

        verify(offenseDao).getOffenseByID(1);
    }

    @Test
    public void testAddOffense() {
        try {
            when(offenseDao.getOffenseByID(addOffense.getId())).thenReturn(null);
            when(offenseDao.addOffense(addOffense)).thenReturn(true);

            boolean result = offenseFacade.addOffense(addOffense);

            assert(result == true);

            assert(offenseFacade.getOffenseByID(2) == null);

            verify(offenseDao).addOffense(addOffense);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }

    }

    @Test
    public void testUpdateOffense() {
        try {
            when(offenseDao.getOffenseByID(offense.getId())).thenReturn(offense);
            when(offenseDao.updateOffense(offense)).thenReturn(true);

            boolean result = offenseFacade.updateOffense(offense);

            assert(result == true);

            assert(offenseFacade.getOffenseByID(1).equals(offense));

            verify(offenseDao).updateOffense(offense);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }
}