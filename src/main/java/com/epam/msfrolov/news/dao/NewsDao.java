package com.epam.msfrolov.news.dao;

import com.epam.msfrolov.news.model.News;

import java.util.List;

public interface NewsDao {

    List<News> getList();

    News save(News news);

    boolean remove(News news);

    News findById(int id);

}
