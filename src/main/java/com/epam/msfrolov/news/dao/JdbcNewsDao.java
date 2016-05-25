package com.epam.msfrolov.news.dao;

import com.epam.msfrolov.news.model.News;
import com.epam.msfrolov.news.util.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcNewsDao implements NewsDao {
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
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            while (resultSet.next()) {
                News news = new News();
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("date_d");
//                LocalDate date = null;
//                if (resultDate != null) {
//                    date = resultDate.toLocalDate();
//                }
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
    public News save(News news) {
        log.debug("SAVE!!!!!1 {}", news);
        log.debug("news date!!!!!1 {}", news.getDate());
        String query = "INSERT INTO NEWS(TITLE,DATE_D,BRIEF,CONTENT) VALUES (?,?,?,?)";
            try (PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setString(1, news.getTitle());
            stm.setDate(2,new Date(news.getDate().getTime()));
            stm.setString(3, news.getBrief());
            stm.setString(4, news.getContent());
            stm.executeQuery();
//            ResultSet generatedKeys = stm.getGeneratedKeys();
//            Integer id = generatedKeys.getInt(1);
//            log.debug("NEW ID: {}", id);
//            news.setId(id);
            return news;
        } catch (Exception e) {
            throw new AppException("Request failed", e);
        }
    }





    @Override
    public boolean remove(News news) {
        return false;
    }

    @Override
    public News findById(int id) {
        //Formation queries
        QueryDesigner query = new QueryDesigner();
        query.select().asterisk()
                .from().table(News.class)
                .where().id().equal().integer(id);
        News news = new News();
        news.setId(id);
        try (PreparedStatement stm = connection.prepareStatement(query.toString())) {
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                Date date = resultSet.getDate("date_d");
//                LocalDate date = null;
//                if (resultDate != null) {
//                    date = resultDate.toLocalDate();
//                }
                String brief = resultSet.getString("brief");
                String content = resultSet.getString("content");
                news.setTitle(title);
                news.setDate(date);
                news.setBrief(brief);
                news.setContent(content);
                //other field
            } else throw new AppException("The object News with [" + id + "] - id is not found");
        } catch (Exception e) {
            throw new AppException("Request failed", e);
        }
        return news;
    }
}
