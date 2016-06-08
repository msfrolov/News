package com.epam.msfrolov.service;

import com.epam.msfrolov.dao.DaoFactory;
import com.epam.msfrolov.model.News;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private final DaoFactory daoFactory;

    public NewsServiceImpl() {
        this.daoFactory = DaoFactory.newInstance();
    }

    public List<News> getList() {
        return daoFactory.getDao().getList();
    }

    public News findById(int id) {
        return daoFactory.getDao().findById(id);
    }

    public News save(News news) {
        return daoFactory.getDao().save(news);
    }

    public News update(News news) {
        return daoFactory.getDao().update(news);
    }

    public int remove(int[] idArray) {
        return daoFactory.getDao().remove(idArray);
    }

    public boolean remove(int id) {
        return daoFactory.getDao().remove(id);
    }

    public News remove(News news) {
        return daoFactory.getDao().remove(news);
    }
}
