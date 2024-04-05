package com.prefect.office.record.management.data.utils;

public class QueryConstants {

    public static final String GET_ALL_CS = "SELECT * FROM comm_serv_rendered";
    public static final String GET_CS_BY_ID = "SELECT * FROM comm_serv_rendered WHERE id = ?";
    public static final String RENDER_CS = "UPDATE comm_serv_rendered SET student_id = ?, date_rendered = ?, hours_rendered = ? WHERE id = ?";


    public static final String GET_ALL_OFFENSES = "SELECT * FROM offense";
    public static final String GET_OFFENSE_BY_ID = "SELECT * FROM offense WHERE id = ?";
    public static final String UPDATE_OFFENSE = "UPDATE offense SET violation_id = ?, student_id = ?, offense_date = ? WHERE id = ?";
    public static final String ADD_OFFENSE = "INSERT INTO offense (violation_id, student_id, offense_date) VALUES (?, ?, ?)";


    public static final String ADD_VIOLATION = "INSERT INTO violation (violation, type, comm_serv_hours) VALUES (?, ?, ?)";
    public static final String GET_ALL_VIOLATION = "SELECT * FROM violation";
}
