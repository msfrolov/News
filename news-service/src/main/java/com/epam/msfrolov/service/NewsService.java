package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;

import java.util.List;

public interface NewsService {

    List<News> getList();

    News findById(int id);

    News save(News news);

    News update(News news);

    void remove(int[] idArray);

    void remove(int id);

    void remove(News news);
}
