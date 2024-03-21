package com.prefect.office.record.management.data.connectionhelper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:rogate";
    private static final String USER = "system";
    private static final String PASSWORD = "Changeme0";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";


    public static Connection getConnection() {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
