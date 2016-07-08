package com.epam.msfrolov.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Class for transfer data between view and controller
 */
public class NewsDTO implements Serializable {


    private Integer id;

    private Date date;


    @NotBlank(message = "error.title.empty")
    @Length(min = 1, max = 100, message = "error.title.size")
    private String title;

    @NotBlank(message = "error.title.empty")
    @Size(min = 1, max = 500, message = "error.title.size")
    private String brief;

    @NotBlank(message = "error.title.empty")
    @Size(min = 1, max = 2048, message = "error.title.size")
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
