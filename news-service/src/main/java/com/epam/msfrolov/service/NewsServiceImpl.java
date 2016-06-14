package com.epam.msfrolov.service;

import com.epam.msfrolov.dao.NewsDao;
import com.epam.msfrolov.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class NewsServiceImpl implements NewsService {

    private static final Logger LOG = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsDao newsDao;

    public NewsServiceImpl() {

    }

    public NewsServiceImpl(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @PostConstruct
    private void postConstruct() {
        LOG.debug("Construct Bean:service");
    }

    @PreDestroy
    private void preDestroy() {
        LOG.debug("Destroy Bean:service");
    }

    public NewsDao getDaoFactory() {
        return newsDao;
    }

    public void setDaoFactory(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public List<News> getList() {
        return newsDao.getList();
    }

    public News findById(int id) {
        return newsDao.findById(id);
    }

    public News save(News news) {
        return newsDao.save(news);
    }

    public News update(News news) {
        return newsDao.update(news);
    }

    public void remove(int[] idArray) {
        newsDao.remove(idArray);
    }

    public void remove(int id) {
        newsDao.remove(id);
    }

    public void remove(News news) {
        newsDao.remove(news);
    }
}
