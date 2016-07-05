package com.epam.msfrolov.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Class for transfer data between view and controller
 */
public class NewsDTO implements Serializable {

    private Integer id;

    private Date date;

    private String title;

    private String brief;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
