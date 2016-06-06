package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaNewsService implements NewsService {

    private static final Logger LOG = LoggerFactory.getLogger(JpaNewsService.class);

    private EntityManager entityManager;

    public JpaNewsService() {
        LOG.debug("WTF1212");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
        LOG.debug("WTF1313");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<News> getList() {
//        TypedQuery<News> namedQuery = entityManager.createNamedQuery("News.getAll", News.class);
//        return namedQuery.getResultList();
        return null;
    }

    public News findById(int id) {
        return entityManager.find(News.class, id);
    }

    public News save(News news) {
        entityManager.getTransaction().begin();
        News newsFromDB = entityManager.merge(news);
        entityManager.getTransaction().commit();
        return newsFromDB;
    }

    public News update(News news) {
        return save(news);
    }

    public int remove(int[] idArray) {

        return 0;
    }

    public boolean remove(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
        //// TODO: 6/6/2016 ?
        return true;
    }

    public News remove(News news) {
        entityManager.getTransaction().begin();
        entityManager.remove(news);
        entityManager.getTransaction().commit();
        //// TODO: 6/6/2016 ?
        return news;
    }
}
