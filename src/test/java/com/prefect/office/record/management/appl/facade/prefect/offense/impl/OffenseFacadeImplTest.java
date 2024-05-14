package com.prefect.office.record.management.appl.facade.prefect.offense.impl;

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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void testAddOffense() {
        try {
            int id = 1;
            String type = "Major";
            String description = "Vandalism";

            Offense offense1 = new Offense(id, type, description);

            offenseFacade.addOffense(offense1);

            verify(offenseDao).addOffense(any(Offense.class));
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

    @Test
    public void testGetOffenseById() {
        when(offenseDao.getOffenseByID(1)).thenReturn(offense);
        Offense expectedOffense = offenseFacade.getOffenseByID(1);

        assert(expectedOffense.equals(offense));

        verify(offenseDao).getOffenseByID(1);
    }

    @Test
    public void testGetAllOffense() {
        when(offenseDao.getAllOffense()).thenReturn(offenseList);

        List<Offense> expectedList = offenseFacade.getAllOffense();

        assert (expectedList.equals(offenseList));
        verify(offenseDao).getAllOffense();
    }

    @Test
    public void testGetOffenseByName() {
        when(offenseDao.getOffenseByName("fighting")).thenReturn(offense);
        Offense expectedOffense = offenseFacade.getOffenseByName("fighting");

        assert(expectedOffense.equals(offense));

        verify(offenseDao).getOffenseByName("fighting");
    }

    @Test
    public void testGetAllOffenseByType() {
        String major = "Major";

        when(offenseDao.getAllOffenseByType(major)).thenReturn(offenseList);

        List<Offense> expectedList = offenseFacade.getAllOffenseByType(major);

        assert (expectedList.equals(offenseList));
        verify(offenseDao).getAllOffenseByType(major);
    }
}
