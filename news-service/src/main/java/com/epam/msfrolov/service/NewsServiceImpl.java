package com.epam.msfrolov.service;

import com.epam.msfrolov.dao.Dao;
import com.epam.msfrolov.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private static final Logger LOG = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private Dao dao;

    public NewsServiceImpl() {

    }

    public NewsServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @PostConstruct
    private void postConstruct() {
        LOG.debug("Construct Bean:service");
    }

    @PreDestroy
    private void preDestroy() {
        LOG.debug("Destroy Bean:service");
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
