package com.epam.msfrolov.news.dao;

import com.epam.msfrolov.news.model.News;
import com.epam.msfrolov.news.util.AppException;
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

    // private
    private static final String INSERT_QUERY = "insert into NEWS(TITLE,DATE_D,BRIEF,CONTENT) values (?,?,?,?)";
    private static final String DELETE_QUERY = "DELETE FROM NEWS WHERE ID = ?";

    private final Connection connection;

    public JdbcNewsDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<News> getList() {
        //prepare statement
        //process statement
        // Prepare
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
            throw new AppException("Failed to process query for to get a list of news from database", e);
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
                .text("content").equal().question().comma()
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
            throw new AppException("Failed to process query for to update change object in database", e);
        }
    }

    @Override
    public News save(News news) {
        String query = INSERT_QUERY;
        try (PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setString(1, news.getTitle());
            stm.setDate(2, new Date(news.getDate().getTime()));
            stm.setString(3, news.getBrief());
            stm.setString(4, news.getContent());
            stm.executeQuery();
            return news;
        } catch (Exception e) {
            throw new AppException("Failed to save object in database", e);
        }
    }

    @Override
    public News remove(News news) {
        if (remove(news.getId())) {
            return news;
        } else {
            throw new AppException("Failed to delete object from database");
        }
    }

    @Override
    public boolean remove(int id) {
        String query = DELETE_QUERY;
        try (PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setInt(1, id);
            return stm.execute();
        } catch (Exception e) {
            throw new AppException("Failed to remove object from database", e);
        }
    }

    @Override
    public int remove(int[] idArray) {
        QueryDesigner query = new QueryDesigner();
        query.delete()
                .from().table(News.class)
                .where();
        for (int i = 0; i < idArray.length; i++) {
            if (i != 0) {
                query.or();
            }
            query.id().equal().question();
        }
        log.debug("remove query: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < idArray.length; i++) {
                stm.setInt(i + 1, idArray[i]);
            }
            return stm.executeUpdate();
        } catch (Exception e) {
            throw new AppException("Failed to delete objects from database", e);
        }
    }

    /**
     * @param id
     * @return
     */
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
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("date_d");
                String brief = resultSet.getString("brief");
                String content = resultSet.getString("content");
                news.setTitle(title);
                news.setDate(date);
                news.setBrief(brief);
                news.setContent(content);
                //other field
            } else {
                throw new AppException("The object News [id=" + id + "] is not found");
            }
        } catch (Exception e) {
            throw new AppException("Request failed", e);
        }
        return news;
    }
}
