package com.epam.msfrolov.news.db.dao;

import com.epam.msfrolov.news.model.News;

import java.util.List;

public interface NewsDao {

    List<News> getList();

    boolean save();

    boolean remove();

    News fetchById();

}
