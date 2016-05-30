package com.epam.msfrolov.news.dao;

import com.epam.msfrolov.news.util.AppException;
import com.epam.msfrolov.news.util.FileManager;

public interface DaoFactory extends AutoCloseable {

    static DaoFactory newInstance() {
        String daoFactoryNameName = FileManager.getProperties("properties/connection.properties").getProperty("dao_factory_name");
        DaoFactory instance;
        try {
            instance = (DaoFactory) Class.forName(daoFactoryNameName).newInstance();
        } catch (ClassNotFoundException | InstantiationException e) {
            throw new AppException("Class DAO factory not found", e);
        } catch (IllegalAccessException e) {
            throw new AppException("Illegal access on some extended DAO factory not found", e);
        } catch (Exception e) {
            throw new AppException("AppException", e);
        }
        return instance;
    }

    NewsDao getDao();

}
