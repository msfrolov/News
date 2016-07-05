package com.epam.msfrolov.adapter;

import com.epam.msfrolov.dto.NewsDTO;
import com.epam.msfrolov.model.News;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Transfer data between com.epam.msfrolov.model.News and com.epam.msfrolov.dto.NewsDTO
 */

@Repository("adapter")
public class DTOAdapter {

    public NewsDTO newsToDto(News news) {
        NewsDTO dto = new NewsDTO();
        dto.setId(news.getId());
        dto.setTitle(news.getTitle());
        dto.setBrief(news.getBrief());
        dto.setDate(news.getDate());
        dto.setContent(news.getContent());
        return dto;
    }

    public News dtoToNews(NewsDTO dto) {
        News news = new News();
        news.setId(dto.getId());
        news.setTitle(dto.getTitle());
        news.setBrief(dto.getBrief());
        news.setDate(dto.getDate());
        news.setContent(dto.getContent());
        return news;
    }

    public List<NewsDTO> newsToDtoList(List<News> newsList) {
        List<NewsDTO> list = new ArrayList<>();
        newsList.forEach(news -> list.add(newsToDto(news)));
        return list;
    }

    public List<News> DtoToNewsList(List<NewsDTO> dtoList) {
        List<News> list = new ArrayList<>();
        dtoList.forEach(dto -> list.add(dtoToNews(dto)));
        return list;
    }

}
