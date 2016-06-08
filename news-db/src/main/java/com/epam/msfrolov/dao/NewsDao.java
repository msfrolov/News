package com.epam.msfrolov.dao;


import com.epam.msfrolov.model.News;

import java.util.List;

public interface NewsDao {

    List<News> getList();

    News update(News news);

    News save(News news);

    News remove(News news);

    boolean remove(int id);

    int remove(int[] idsToRemove);

    News findById(int id);

}
