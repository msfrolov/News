package com.epam.msfrolov.news.dao;

import com.epam.msfrolov.news.util.AppException;
import com.epam.msfrolov.news.util.FileManager;

public interface DaoFactory extends AutoCloseable {

    static DaoFactory newInstance() {
        String daoFactoryImplementName = FileManager.getProperties("properties/connection.properties").getProperty("dao.factory.name");
        try {
            return (DaoFactory) Class.forName(daoFactoryImplementName).newInstance();
        } catch (ClassNotFoundException e) {
            throw new AppException("Class DAO factory not found", e);
        } catch (InstantiationException e) {
            throw new AppException("Class DAO factory not init", e);
        } catch (IllegalAccessException e) {
            throw new AppException("Illegal access on some extended DAO factory not found", e);
        } catch (Exception e) {
            throw new AppException("Failed to get DAO factory instance", e);
        }
    }

    NewsDao getDao();

    @Override
    void close();
}
