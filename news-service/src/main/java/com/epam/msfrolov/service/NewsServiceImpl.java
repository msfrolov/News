package com.epam.msfrolov.service;

import com.epam.msfrolov.dao.Dao;
import com.epam.msfrolov.model.News;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private Dao dao;

    public NewsServiceImpl() {

    }

    public NewsServiceImpl(Dao dao) {
        this.dao = dao;
    }

    public Dao getDaoFactory() {
        return dao;
    }

    public void setDaoFactory(Dao dao) {
        this.dao = dao;
    }

    public List<News> getList() {
        return dao.getList();
    }

    public News findById(int id) {
        return dao.findById(id);
    }

    public News save(News news) {
        return dao.save(news);
    }

    public News update(News news) {
        return dao.update(news);
    }

    public int remove(int[] idArray) {
        return dao.remove(idArray);
    }

    public boolean remove(int id) {
        return dao.remove(id);
    }

    public News remove(News news) {
        return dao.remove(news);
    }
}
