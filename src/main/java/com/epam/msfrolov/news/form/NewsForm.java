package com.epam.msfrolov.news.form;

import com.epam.msfrolov.news.model.News;
import org.apache.struts.action.ActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NewsForm extends ActionForm {
    private final static Logger log = LoggerFactory.getLogger(NewsForm.class);

    private int idNews;
    private News news = new News();
    private List<News> newsList;
    private int[] idList;

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

    public int[] getIdList() {
        return idList;
    }

    public void setIdList(int[] idList) {
        this.idList = idList;
    }
}
