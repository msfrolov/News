package com.epam.msfrolov.news.dao;

import com.epam.msfrolov.news.model.News;

import java.util.List;

interface NewsDao {

    List<News> getList();

    News update(News news);

    News save(News news);

    News remove(News news);

    boolean remove(int id);

    int remove(int[] idArray);

    News findById(int id);

}
