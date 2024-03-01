package com.view.history.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:rogate";
    public static final String ORACLE_DRIVER = "oracle.jbdc.driver.OracleDriver";

    public static final String USERNAME = "system";

    public static final String PASSWORD = "Changeme0";

    public static Connection getConnection(){
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch(Exception e){
            throw new RuntimeException("error connecting to database!", e);
        }
    }
}

