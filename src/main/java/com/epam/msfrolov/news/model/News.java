package com.epam.msfrolov.news.model;


import com.epam.msfrolov.news.util.AppException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;

public class News extends BaseEntity {
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

    public Date setStringToData(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return simpleDateFormat.parse(s);
        } catch (Exception e) {
            throw new AppException("ParseException", e);
        }
    }

    public String getDataToString() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return simpleDateFormat.format(date);
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
