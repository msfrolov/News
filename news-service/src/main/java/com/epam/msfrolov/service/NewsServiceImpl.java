package com.epam.msfrolov.service;

import com.epam.msfrolov.adapter.DTOAdapter;
import com.epam.msfrolov.dto.NewsDTO;
import com.epam.msfrolov.model.News;
import com.epam.msfrolov.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Repository("newsService")
@Transactional
@Lazy
public class NewsServiceImpl implements NewsService {

    private static final Logger LOG = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    @Qualifier("newsRepository")
    private NewsRepository newsRepository;

    @Autowired
    @Qualifier("adapter")
    private DTOAdapter adapter;

    @Autowired
    private MessageSource ms;

    public NewsServiceImpl() {
    }

    @Override
    public List<NewsDTO> getAll() {
        return adapter.newsToDtoList(newsRepository.findAll());
    }

    @Override
    public NewsDTO findById(int id) {
        LOG.debug("!!!", ms.getMessage("error.title.empty", null, new Locale("en")));
        LOG.debug("!!!", ms.getMessage("error.title.size", null, new Locale("ru")));
        return adapter.newsToDto(newsRepository.findOne(id));
    }

    @Override
    public NewsDTO save(NewsDTO dto) {
        News news = adapter.dtoToNews(dto);
        News savedNews = newsRepository.saveAndFlush(news);
        return adapter.newsToDto(savedNews);
    }

    @Override
    public NewsDTO update(NewsDTO dto) {
        News news = adapter.dtoToNews(dto);
        News savedNews = newsRepository.saveAndFlush(news);
        return adapter.newsToDto(savedNews);
    }

    @Override
    public void remove(Integer[] arrayId) {
        List<News> newsListForDelete = newsRepository.findAll(Arrays.asList(arrayId));
        newsRepository.delete(newsListForDelete);
    }

    @Override
    public void remove(int id) {
        newsRepository.delete(id);
    }

    @Override
    public void remove(NewsDTO dto) {
        newsRepository.delete(adapter.dtoToNews(dto));
    }

    public NewsRepository getNewsRepository() {
        return newsRepository;
    }

    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
