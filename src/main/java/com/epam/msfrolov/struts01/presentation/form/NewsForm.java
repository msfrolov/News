package com.epam.msfrolov.struts01.presentation.form;

import org.apache.struts.action.ActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewsForm extends ActionForm {
    private final static Logger log = LoggerFactory.getLogger(NewsForm.class);

    private Integer id;
    private String title;
    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
