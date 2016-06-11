package com.epam.msfrolov.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NEWS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(
                name = "News.getAll",
                query = "select n from News n"
        ),
        @NamedQuery(
                name = "News.getByIdParam",
                query = "select n from News n " +
                        "where n.id = :id"
        )
})
public class News extends BaseEntity {

    @Column(name = "DATE_D")
    private Date date;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BRIEF")
    private String brief;

    @Column(name = "CONTENT")
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
