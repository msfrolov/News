package com.epam.msfrolov.dao.jdbc;

import com.epam.msfrolov.dao.NewsDao;
import com.epam.msfrolov.exception.DatabaseModuleException;
import com.epam.msfrolov.model.News;
import com.epam.msfrolov.query.QueryDesigner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    private static final Logger log = LoggerFactory.getLogger(JdbcNewsDao.class);

    private final Connection connection;

    JdbcNewsDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public News findById(int id) {
        QueryDesigner query = new QueryDesigner();
        query.select().asterisk()
                .from().table(News.class)
                .where().id().equal().integer(id);
        News news = new News();
        news.setId(id);
        log.debug("findById query: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            if (resultSet.next()) {
                news.setTitle(resultSet.getString("title"));
                news.setDate(resultSet.getDate("date_d"));
                news.setBrief(resultSet.getString("brief"));
                news.setContent(resultSet.getString("content"));
            } else {
                throw new DatabaseModuleException("The object News [id=" + id + "] is not found");
            }
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to find objects from database", e);
        }
        return news;
    }

    @Override
    public List<News> getList() {
        QueryDesigner query = new QueryDesigner();
        query.select().asterisk()
                .from().table(News.class);
        log.debug("Query getList: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            List<News> newsList = new ArrayList<>();
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setTitle(resultSet.getString("title"));
                news.setDate(resultSet.getDate("date_d"));
                news.setBrief(resultSet.getString("brief"));
                news.setContent(resultSet.getString("content"));
                newsList.add(news);
            }
            return newsList;
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to process query for to get a list of news from database", e);
        }
    }

    @Override
    public News save(News news) {
        QueryDesigner query = new QueryDesigner();
        query.insertInto().table(News.class)
                .ob().text("title").comma()
                .text("date_d").comma()
                .text("brief").comma()
                .text("content").cb()
                .values()
                .ob().question().comma().question().comma().question().comma().question().cb();
        log.debug("Query save: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString(), new String[]{"ID"})) {
            log.debug("Object: {}", news);
            stm.setString(1, news.getTitle());
            stm.setDate(2, new Date(news.getDate().getTime()));
            stm.setString(3, news.getBrief());
            stm.setString(4, news.getContent());
            stm.executeQuery();
            ResultSet generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            news.setId(generatedKeys.getInt(1));
            return news;
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to save object in database", e);
        }
    }

    @Override
    public News update(News news) {
        QueryDesigner query = new QueryDesigner();
        query.update().table(News.class)
                .set()
                .text("title").equal().question().comma()
                .text("date_d").equal().question().comma()
                .text("brief").equal().question().comma()
                .text("content").equal().question()
                .where().id().equal().question();
        log.debug("Query update: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            stm.setString(1, news.getTitle());
            stm.setDate(2, new Date(news.getDate().getTime()));
            stm.setString(3, news.getBrief());
            stm.setString(4, news.getContent());
            stm.setInt(5, news.getId());
            stm.executeUpdate();
            return news;
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to process query for to update change object in database", e);
        }
    }

    @Override
    public News remove(News news) {
        if (remove(news.getId())) {
            return news;
        } else {
            throw new DatabaseModuleException("Failed to delete object from database");
        }
    }

    @Override
    public boolean remove(int id) {
        QueryDesigner query = new QueryDesigner();
        query.delete()
                .from().table(News.class)
                .where().id().equal().question();
        log.debug("Query remove: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            stm.setInt(1, id);
            return stm.execute();
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to remove object from database", e);
        }
    }

    @Override
    public int remove(int[] idsToRemove) {
        QueryDesigner query = new QueryDesigner();
        query.delete()
                .from().table(News.class)
                .where();
        for (int i = 0; i < idsToRemove.length; i++) {
            if (i != 0) {
                query.or();
            }
            query.id().equal().question();
        }
        log.debug("remove query: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < idsToRemove.length; i++) {
                stm.setInt(i + 1, idsToRemove[i]);
            }
            return stm.executeUpdate();
        } catch (Exception e) {
            throw new DatabaseModuleException("Failed to delete objects from database", e);
        }
    }

}
