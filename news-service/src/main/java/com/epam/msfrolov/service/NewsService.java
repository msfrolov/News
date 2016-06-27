package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;

import java.util.List;

public interface NewsService {

    List<News> getAll();

    News findById(int id);

    News save(News news);

    News update(News news);

    void remove(Integer [] idArray);

    void remove(int id);

    void remove(News news);
}
