package com.epam.msfrolov.dao.jpa;

import com.epam.msfrolov.dao.DaoFactory;
import com.epam.msfrolov.dao.NewsDao;

public class JpaDaoFactory implements DaoFactory {

//    private final Connection connection;

    public JpaDaoFactory() {
//        connection = DBConnectionPool.getConnection();
    }


    @Override
    public NewsDao getDao() {
        return new JpaNewsDao();
    }

    @Override
    public void close() {
//        try {
//            if (connection != null)
//                connection.close();
//        } catch (Exception e) {
//            throw new DatabaseModuleException("It failed to close or symbol not open", e);
//        }
    }
}
