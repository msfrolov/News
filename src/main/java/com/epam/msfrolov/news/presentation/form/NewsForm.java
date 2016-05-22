package com.epam.msfrolov.news.presentation.form;

import com.epam.msfrolov.news.model.News;
import org.apache.struts.action.ActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NewsForm extends ActionForm {
    private final static Logger log = LoggerFactory.getLogger(NewsForm.class);

    private Integer idNews;
    private News news;
    private List<News> newsList;
    private Integer[] idList;

    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
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

    public Integer[] getIdList() {
        return idList;
    }

    public void setIdList(Integer[] idList) {
        this.idList = idList;
    }
}
