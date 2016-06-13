package com.epam.msfrolov.dao;

import com.epam.msfrolov.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaNewsDao implements Dao {

    private static final Logger LOG = LoggerFactory.getLogger(JpaNewsDao.class);

    private EntityManager entityManager;

    public JpaNewsDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oraclePU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<News> getList() {
        TypedQuery<News> namedQuery = entityManager.createNamedQuery("News.getAll", News.class);
        return namedQuery.getResultList();
    }

    public News findById(int id) {
        TypedQuery<News> getByIdParam = entityManager.createNamedQuery("News.getByIdParam", News.class);
        getByIdParam.setParameter("id", id);
        return getByIdParam.getSingleResult();
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

    public int remove(int[] idsToRemove) {
        entityManager.getTransaction().begin();
        for (int i : idsToRemove) {
            entityManager.remove(findById(i));
        }
        entityManager.getTransaction().commit();
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
