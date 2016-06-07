package com.epam.msfrolov.dao.jdbc;

import com.epam.msfrolov.dao.DaoFactory;
import com.epam.msfrolov.dao.NewsDao;
import com.epam.msfrolov.exception.DatabaseModuleException;
import com.epam.msfrolov.pool.DBConnectionPool;

import java.sql.Connection;

public class JdbcDaoFactory implements DaoFactory {

    private final Connection connection;

    public JdbcDaoFactory() {
        connection = DBConnectionPool.getConnection();
    }


    @Override
    public NewsDao getDao() {
        return new JdbcNewsDao(connection);
    }

    @Override
    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            throw new DatabaseModuleException("It failed to close or symbol not open", e);
        }
    }
}
