package com.offense.view.data.offense.dao;

import com.offense.view.app.model.offense.Offense;

import java.util.List;

public interface OffenseDao {

List<Offense> getAllOffenses();
Offense getOffenseById(String id);
}
