package com.epam.msfrolov.news.model;


import com.epam.msfrolov.news.util.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(News.class);
    private Date date;
    private String title;
    private String brief;
    private String content;

    public News() {
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateFormat(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date date = simpleDateFormat.parse(dateString);
            log.debug("dateToString", date.toString());
            this.date = date;
        } catch (Exception e) {
            throw new AppException("ParseException", e);
        }
    }

    public String getDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String s = simpleDateFormat.format(date);
        log.debug("dateToString", s);
        return s;

    }

    public String getIdString() {
        return String.valueOf(getId());
    }

    public void setIdString(String id) {
        setId(Integer.valueOf(id));
    }





    @Override
    public String toString() {
        return "News{" +
                "id=" + getId() +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
