package com.offense.view.data.offense.dao.impl;

import com.offense.view.app.model.offense.Offense;
import com.offense.view.data.connection.ConnectionHelper;
import com.offense.view.data.offense.dao.OffenseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OffenseDaoImpl implements OffenseDao {

    @Override
    public List<Offense> getAllOffenses() {
        List<Offense> offenses = new ArrayList<>();

        try {
            Connection c = ConnectionHelper.getConnection();
            PreparedStatement statement = c.prepareStatement("select * from offense");
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                Offense offense = new Offense();
                offense.setId(r.getString("id"));
                offense.setViolation_id(r.getString("violation_id"));
                offense.setStudent_id(r.getString("student_id"));
                offense.setOffense_date(r.getTimestamp("offense_date"));

                offenses.add(offense);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return offenses;
    }

    @Override
    public Offense getOffenseById(String id) {
        return null;
    }
}
