package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle {
    private static final String URL = "jdbc:oracle:thin:@167.99.228.226:1521:XE";
    private static final String DRIVER_NAME_ORACLE = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "Dev";
    private static final String PASSWORD = "dev";
        
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_NAME_ORACLE);
        Connection con =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return con;
    }
}
