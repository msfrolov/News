package com.epam.msfrolov.dao.jpa;

import com.epam.msfrolov.dao.NewsDao;
import com.epam.msfrolov.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaNewsDao implements NewsDao {

    private static final Logger LOG = LoggerFactory.getLogger(JpaNewsDao.class);

    private EntityManager entityManager;

    public JpaNewsDao() {
        LOG.debug("WTF121212");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
        LOG.debug("WTF131313");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<News> getList() {
        LOG.debug("WTF GET LIST ????");
        TypedQuery<News> namedQuery = entityManager.createNamedQuery("News.getAll", News.class);
        return namedQuery.getResultList();
    }

    public News findById(int id) {
        LOG.debug("WTF FIND BY ID = {}", id);
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
