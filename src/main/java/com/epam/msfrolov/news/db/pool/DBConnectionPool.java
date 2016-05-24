package com.epam.msfrolov.news.db.pool;

import com.epam.msfrolov.news.util.AppException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionPool {

//    public static Connection getConnection() {
//        try {
//            Class.forName("oracle.jdbc.OracleDriver");
//            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "FROLOV", "Qwer55355");
//            return connection;
//        } catch (Exception e) {
//            throw new AppException("Failed to get connection", e);
//        }
//    }
 public static Connection getConnection() {
        try {
            return InstanceHolder.getInstance().getConnection();
        } catch (SQLException e) {
            throw new AppException("Failed to get connection", e);
        }
    }

    private static class InstanceHolder {
        private static final DataSource DATASOURCE = create();

        private static DataSource create() {
            InitialContext initialContext;
            DataSource dataSource;
            try {
                initialContext = new InitialContext();
                dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/news");
            } catch (Exception e) {
                throw new AppException("InitialContext exception", e);
            }
            return dataSource;
        }

        private static DataSource getInstance() {
            return DATASOURCE;
        }
    }
}
