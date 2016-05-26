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
    public static final String UPDATE_QUERY = "UPDATE NEWS SET TITLE = ? , DATE_D = ? , BRIEF = ?, CONTENT = ? WHERE ID = ?";
    public static final String INSERT_QUERY = "INSERT INTO NEWS(TITLE,DATE_D,BRIEF,CONTENT) VALUES (?,?,?,?)";
    public static final String DELETE_QUERY = "DELETE FROM NEWS WHERE ID = ?";
    private static final Logger log = LoggerFactory.getLogger(JdbcNewsDao.class);
    private final Connection connection;

    protected JdbcNewsDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<News> getList() {
        //Formation queries
        QueryDesigner query = new QueryDesigner();
        query.select().asterisk()
                .from().table(News.class);
        List<News> newsList = new ArrayList<>();
        log.debug("getList query: {}", query.toString());
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            while (resultSet.next()) {
                News news = new News();
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("date_d");
                String brief = resultSet.getString("brief");
                String content = resultSet.getString("content");
                news.setId(id);
                news.setTitle(title);
                news.setDate(date);
                news.setBrief(brief);
                news.setContent(content);
                newsList.add(news);
            }
        } catch (Exception e) {
            throw new AppException("Request failed", e);
        }
        return newsList;
    }

    @Override
    public News update(News news) {
        String query = UPDATE_QUERY;
        log.debug("update query: {}", query);
        try (PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setString(1, news.getTitle());
            stm.setDate(2, new Date(news.getDate().getTime()));
            stm.setString(3, news.getBrief());
            stm.setString(4, news.getContent());
            stm.setInt(5, news.getId());
            if (stm.executeUpdate() > 0) return news;
            else throw new AppException();
        } catch (Exception e) {
            throw new AppException("Failed to update change object in database", e);
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
        if (remove(news.getId()))
            return news;
        else
            throw new AppException("Failed to delete object from database");
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
                .where().id().equal();
        for (int i = 0; i < idArray.length; i++) {
            if (i != 0) query.or();
            query.question();
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
            } else throw new AppException("The object News [id=" + id + "] is not found");
        } catch (Exception e) {
            throw new AppException("Request failed", e);
        }
        return news;
    }
}
