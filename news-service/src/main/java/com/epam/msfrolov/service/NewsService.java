package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;

import java.util.List;

public interface NewsService {

    List<News> getList();

    News findById(int id);

    News save(News news);

    News update(News news);

    int remove(int[] idArray);

    boolean remove(int id);

    News remove(News news);
}
