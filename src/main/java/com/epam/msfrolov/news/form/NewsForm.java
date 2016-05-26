package com.epam.msfrolov.news.form;

import com.epam.msfrolov.news.model.News;
import com.epam.msfrolov.news.util.AppException;
import org.apache.struts.action.ActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsForm extends ActionForm {
    private final static Logger log = LoggerFactory.getLogger(NewsForm.class);

    private int idNews;
    private News news = new News();
    private List<News> newsList;
    private int[] idList;
    private String id;
    private String date;
    private String title;
    private String brief;
    private String content;

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public int[] getIdArray() {
        return idList;
    }

    public void setIdList(int[] idList) {
        this.idList = idList;
    }

    ///Entity//
    public void setId(String id) {
        this.id = id;
        try {
            Integer integerId = Integer.valueOf(id);
            log.debug("parse integerID: {}", integerId);
            news.setId(integerId);
        } catch (Exception e) {
            throw new AppException("Parse exception", e);
        }
    }

    public String getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
        try {
            Date parse = new SimpleDateFormat("MM/dd/yyyy").parse(date);
            log.debug("parse date: {}", parse);
            news.setDate(parse);
        } catch (Exception e) {
            throw new AppException("Parse exception", e);
        }
    }

    public String getDate() {
        return date;
    }
}
