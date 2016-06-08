package com.epam.msfrolov.dao;

import com.epam.msfrolov.exception.DatabaseModuleException;
import com.epam.msfrolov.util.FileUtil;


public interface DaoFactory extends AutoCloseable {

    static DaoFactory newInstance() {
        String daoFactoryImplementName = FileUtil.getProperties("properties/connection.properties").getProperty("dao.factory.name");
        try {
            return (DaoFactory) Class.forName(daoFactoryImplementName).newInstance();
        } catch (ClassNotFoundException e) {
            throw new DatabaseModuleException("Class DAO factory not found", e);
        } catch (InstantiationException e) {
            throw new DatabaseModuleException("Class DAO factory not init", e);
        } catch (IllegalAccessException e) {
            throw new DatabaseModuleException("Illegal access on some extended DAO factory not found", e);
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to get DAO factory instance", e);
        }
    }

    NewsDao getDao();

}
