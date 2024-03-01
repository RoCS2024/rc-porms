package com.add.offense.data.dao.offense.impl;

import com.add.offense.app.model.offense.Offense;
import com.add.offense.data.connection.ConnectionHelper;
import com.add.offense.data.dao.offense.OffenseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public class OffenseDaoImpl implements OffenseDao {
    private static final String GET_STUDENT_BY_ID_STATEMENT = " ";
     Connection con = new ConnectionHelper().getConnection(); ;

    private Offense setOffense(ResultSet rs) {
        try {

            Offense offense = new Offense();
            offense.setId(rs.getLong("id"));
            offense.setViolationId(rs.getLong("violation_id"));
            offense.setStudentId(rs.getString("student_id"));
//            offense.setOffenseDate(rs.getTimestamp("offense_date").toLocalDateTime());
            return offense;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String buildParameters(List<String> ids) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (String id : ids) {
            sb.append("?, ");
        }
        //delete the last character added which is
        String params = sb.deleteCharAt(sb.length() - 1).toString();

        //delete the second to the last character added which is ","
        params = sb.deleteCharAt(sb.length() - 1).toString();

        params = params + ")";

        return params;
    }

    @Override
    public boolean saveOffense(Offense offense) {
        try (PreparedStatement statement = con.prepareStatement("INSERT INTO offense (student_id, violation_id) VALUES (?, ?)")) {
            statement.setString(1, offense.getStudentId());

            Long violationId = offense.getViolationId();
            if (violationId != null) {
                statement.setLong(2, violationId);
            } else {

            }
            int result = statement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Offense getOffenseById(long id) {
        try {
            PreparedStatement statement = con.prepareStatement(GET_STUDENT_BY_ID_STATEMENT);
            ResultSet rs = statement.executeQuery();
            return rs.next() ? getOffenseById(Long.parseLong(String.valueOf(rs))) : null;

        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Object getOffenseById() {
        return null;
    }
}

