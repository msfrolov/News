package com.epam.msfrolov.form;

import com.epam.msfrolov.exception.DatabaseModuleException;
import com.epam.msfrolov.model.News;
import org.apache.struts.action.ActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsForm extends ActionForm {

    private final static Logger log = LoggerFactory.getLogger(NewsForm.class);

    private int idNews;
    private News news = new News();
    private List<News> newsList;
    private int[] idArray;
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
        setId(integerToString(news.getId()));
        setDate(dateToString(news.getDate()));
        setTitle(news.getTitle());
        setBrief(news.getBrief());
        setContent(news.getContent());
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public int[] getIdArray() {
        return idArray;
    }

    public void setIdArray(int[] idArray) {
        this.idArray = idArray;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        news.setId(stringToInteger(id));
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        news.setDate(stringToDate(date));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        news.setTitle(title);
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
        news.setBrief(brief);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        news.setContent(content);
    }

    //Types adapters

    private String dateToString(Date date) {
        String dateString;
        if (date == null) {
            dateString = "";
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            try {
                dateString = simpleDateFormat.format(date);
            } catch (Exception e) {
                throw new DatabaseModuleException("Failed to format date [" + date + "] for field", e);
            }
        }
        return dateString;
    }

    Date stringToDate(String dateString) {
        boolean isValid;
        Date parsedDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            parsedDate = dateFormat.parse(dateString);
            isValid = dateFormat.format(parsedDate).equals(dateString);
        } catch (Exception e) {
            isValid = false;
        }
        if (!isValid) {
            throw new DatabaseModuleException("Failed to parse date [" + dateString + "] from field");
        }
        return parsedDate;
    }

    private String integerToString(Integer integer) {
        String idString = "";
        try {
            idString = String.valueOf(integer);
            if (idString == null) {
                idString = "";
            }
        } catch (Exception ignored) {
        }
        return idString;
    }

    private Integer stringToInteger(String string) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(string);
        } catch (Exception ignored) {
        }
        return integer;
    }


}
