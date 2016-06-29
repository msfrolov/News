package com.epam.msfrolov.adapter;

import com.epam.msfrolov.dto.DTO;
import com.epam.msfrolov.model.News;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Transfer data between com.epam.msfrolov.model.News and com.epam.msfrolov.dto.DTO
 */

@Repository("adapter")
public class DTOAdapter {

    public DTO newsToDto(News news) {
        DTO dto = new DTO();
        dto.setId(news.getId());
        dto.setBrief(news.getBrief());
        dto.setDate(news.getDate());
        dto.setContent(news.getContent());
        return dto;
    }

    public News dtoToNews(DTO dto) {
        News news = new News();
        news.setId(dto.getId());
        news.setBrief(dto.getBrief());
        news.setDate(dto.getDate());
        news.setContent(dto.getContent());
        return news;
    }

    public List<DTO> newsToDtoList(List<News> newsList) {
        List<DTO> list = new ArrayList<>();
        newsList.forEach(news -> list.add(newsToDto(news)));
        return list;
    }

    public List<News> DtoToNewsList(List<DTO> dtoList) {
        List<News> list = new ArrayList<>();
        dtoList.forEach(dto -> list.add(dtoToNews(dto)));
        return list;
    }


}
