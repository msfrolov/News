package com.epam.msfrolov.news.db.dao;

import com.epam.msfrolov.news.util.AppException;
import com.epam.msfrolov.news.util.FileManager;

public interface DaoFactory extends AutoCloseable {

    static DaoFactory newInstance() {
        String daoFactoryNameName = FileManager.getProperties("properties/connection.properties").getProperty("dao_factory_name");
        DaoFactory instance = null;
        try {
            instance = (DaoFactory) Class.forName(daoFactoryNameName).newInstance();
        } catch (ClassNotFoundException e) {
            new AppException("Class DAO factory not found", e);
        } catch (InstantiationException e) {
            new AppException("Class DAO factory not found", e);
        } catch (IllegalAccessException e) {
            new AppException("Illegal access on some extended DAO factory not found", e);
        }
        return instance;
    }

    NewsDao getDao();

    @Override
    void close();
}
