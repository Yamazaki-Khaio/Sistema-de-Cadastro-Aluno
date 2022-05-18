package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    public Connection databaseLink;
    public Connection getConnection() {
    	
        String databaseName = "sis_alunos_db";
        String databaseUser = "Yamazaki";
        String databasePassword = "28312720BCK@";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink  = DriverManager.getConnection(url,databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }

}

