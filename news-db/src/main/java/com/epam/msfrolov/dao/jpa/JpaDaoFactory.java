package com.epam.msfrolov.dao.jpa;

import com.epam.msfrolov.dao.Dao;
import com.epam.msfrolov.dao.DaoFactory;

public class JpaDaoFactory implements DaoFactory {

    public JpaDaoFactory() {
    }

    @Override
    public Dao getDao() {
        return new JpaNewsDao();
    }

    @Override
    public void close() {

    }
}
