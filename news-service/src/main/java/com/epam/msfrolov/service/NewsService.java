package com.epam.msfrolov.service;

import com.epam.msfrolov.dto.NewsDTO;

import java.util.List;

public interface NewsService {

    List<NewsDTO> getAll();

    NewsDTO findById(int id);

    NewsDTO save(NewsDTO dto);

    NewsDTO update(NewsDTO dto);

    void remove(Integer[] idArray);

    void remove(int id);

    void remove(NewsDTO dto);
}
