package com.epam.msfrolov.pool;

import com.epam.msfrolov.exception.DatabaseModuleException;
import com.epam.msfrolov.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Properties;

/**
 * @deprecated Use Hibernate pool instead
 */
@Deprecated
public class DBConnectionPool {
    private static final Logger log = LoggerFactory.getLogger(DBConnectionPool.class);

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed init class jdbc", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties properties = FileUtil.getProperties("properties/connection.properties");
            String url = properties.getProperty("db.param.url");
            String user = properties.getProperty("db.param.user");
            String password = properties.getProperty("db.param.password");
            Locale.setDefault(Locale.ENGLISH);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to get connection", e);
        }
    }
}
