package com.prefect.office.record.management.data.utils;

public class QueryConstants {

    public static final String GET_ALL_CS_STATEMENT = "SELECT * FROM comm_serv_rendered";
    public static final String GET_CS_BY_ID_STATEMENT = "SELECT * FROM comm_serv_rendered WHERE id = ?";
    public static final String RENDER_CS_STATEMENT = "UPDATE comm_serv_rendered SET student_id = ?, date_rendered = ?, hours_rendered = ? WHERE id = ?";


    public static final String GET_ALL_OFFENSES_STATEMENT = "SELECT * FROM offense";
    public static final String GET_OFFENSE_BY_ID_STATEMENT = "SELECT * FROM offense WHERE id = ?";
    public static final String UPDATE_OFFENSE_STATEMENT = "UPDATE offense SET violation_id = ?, student_id = ?, offense_date = ? WHERE id = ?";
    public static final String ADD_OFFENSE_STATEMENT = "INSERT INTO offense (violation_id, student_id, offense_date) VALUES (?, ?, ?)";


    public static final String ADD_VIOLATION_STATEMENT = "INSERT INTO violation (violation, type, comm_serv_hours) VALUES (?, ?, ?)";
    public static final String GET_ALL_VIOLATION_STATEMENT = "SELECT * FROM violation";
}
