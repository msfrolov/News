package com.epam.msfrolov.dao;


import com.epam.msfrolov.model.News;

import java.util.List;

public interface NewsDao {

    List<News> getList();

    News update(News news);

    News save(News news);

    void remove(News news);

    void remove(int id);

    void remove(int[] idsToRemove);

    News findById(int id);

}
