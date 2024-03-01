package com.add.offense.data.offense.dao.impl;

import com.add.offense.app.facade.offense.OffenseFacade;
import com.add.offense.app.facade.offense.impl.OffenseFacadeImpl;
import com.add.offense.app.model.offense.Offense;
import com.add.offense.data.dao.offense.OffenseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OffenseDaoImplTest {
    private OffenseFacade offenseFacade;
    private OffenseDao offenseDaoMock;

    @BeforeEach
    public void setUp() {
        offenseDaoMock = mock(OffenseDao.class);
        offenseFacade = new OffenseFacadeImpl();
    }

    @Test
    public void saveOffense() {
        Offense offense = new Offense();
        when(offenseFacade.saveOffense(offense)).thenReturn(true);

        assertTrue(offenseFacade.saveOffense(offense));
    }

    @Test
    public void getOffenseById() {

        Offense expectedOffense = new Offense();
        when(offenseDaoMock.getOffenseById()).thenReturn(expectedOffense);

        Offense retrievedOffense = offenseFacade.getOffenseById();

        assertEquals(expectedOffense, retrievedOffense);
    }
}