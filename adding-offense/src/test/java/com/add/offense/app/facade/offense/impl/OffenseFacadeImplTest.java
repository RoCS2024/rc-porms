package com.add.offense.app.facade.offense.impl;

import com.add.offense.app.model.offense.Offense;
import com.add.offense.data.dao.offense.OffenseDao;
import com.add.offense.data.dao.offense.impl.OffenseDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class OffenseFacadeImplTest {
    private OffenseDao offenseDao;
    private List<String> studentIds;
    private OffenseFacadeImpl offenseDaoMock;
    private OffenseFacadeImpl offenseFacade;

    @BeforeEach
    public void setUp() {
        offenseDao = new OffenseDaoImpl();
        studentIds = new ArrayList<>();
        studentIds.add("123");
        studentIds.add("456");
    }

    @Test
    public void saveOffense() {
        Offense offense = new Offense();
        offense.setViolationId(1L);
        offense.setStudentId("123");
        assertEquals(offense, offense);
    }

    @Test
    public void getOffenseById() {
        Offense expectedOffense = new Offense();
        expectedOffense.setId(1L);
        when(offenseDaoMock.getOffenseById(1L)).thenReturn(expectedOffense);
        Offense retrievedOffense = offenseFacade.getOffenseById(1L);
        assertEquals(expectedOffense, retrievedOffense);
    }

    @Test
    public void buildParameters() {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");

        String parameters = ((OffenseDaoImpl) offenseDao).buildParameters(ids);

        assertEquals("(?, ?, ?)", parameters);
    }
}