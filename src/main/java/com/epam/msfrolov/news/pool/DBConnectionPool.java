package com.epam.msfrolov.news.pool;

import com.epam.msfrolov.news.util.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class DBConnectionPool {
    private static final Logger log = LoggerFactory.getLogger(DBConnectionPool.class);
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            throw new AppException("Failed init class jdbc", e);
        }
    }

    public static Connection getConnection() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "FROLOV", "Qwer55355");
            return connection;
        } catch (Exception e) {
            throw new AppException("Failed to get connection", e);
        }
    }
// public static Connection getConnection() {
//        try {
//            DataSource instance = InstanceHolder.getInstance();
//            log.debug("1", instance);
//            Connection connection = instance.getConnection();
//            log.debug("2", connection);
//            return connection;
//        } catch (Exception e) {
//            throw new AppException("Failed to get connection", e);
//        }
//    }
//
//    private static class InstanceHolder {
//        private static final DataSource DATASOURCE = create();
//
//        private static DataSource create() {
//            InitialContext initialContext;
//            DataSource dataSource;
//            try {
//                initialContext = new InitialContext();
//                dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/news");
//            } catch (Exception e) {
//                throw new AppException("InitialContext exception", e);
//            }
//            return dataSource;
//        }
//
//        private static DataSource getInstance() {
//            return DATASOURCE;
//        }
//    }
}
