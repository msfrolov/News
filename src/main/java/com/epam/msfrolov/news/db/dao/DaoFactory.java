package com.epam.msfrolov.news.db.dao;

import com.epam.msfrolov.news.exception.AppException;
import com.epam.msfrolov.news.util.FileUtil;

public interface DaoFactory extends AutoCloseable {

    static DaoFactory newInstance() {
        String daoFactoryImplementName = FileUtil.getProperties("properties/connection.properties").getProperty("dao.factory.name");
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
