package com.epam.msfrolov.pool;

import com.epam.msfrolov.exception.AppException;
import com.epam.msfrolov.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Properties;

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
            Properties properties = FileUtil.getProperties("properties/connection.properties");
            String url = properties.getProperty("db.param.url");
            String user = properties.getProperty("db.param.user");
            String password = properties.getProperty("db.param.password");
            Locale.setDefault(Locale.ENGLISH);
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            throw new AppException("Failed to get connection", e);
        }
    }
}
