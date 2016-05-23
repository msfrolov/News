package com.epam.msfrolov.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public class Runner {
    private static final Logger log = LoggerFactory.getLogger(Runner.class);
    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","FROLOV","Qwer55355");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM FROLOV.MAIN;");
            while (resultSet.next()){
                String string = resultSet.getString(1);
                log.debug("exam: {}", string);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
