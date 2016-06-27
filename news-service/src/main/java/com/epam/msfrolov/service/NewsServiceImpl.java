package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;
import com.epam.msfrolov.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Repository("newsService")
@Transactional
@Lazy
public class NewsServiceImpl implements NewsService {

    @Autowired
    @Qualifier("newsRepository")
    private NewsRepository newsRepository;

    public NewsServiceImpl() {
    }

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(int id) {
        return newsRepository.findOne(id);
    }

    @Override
    public News save(News news) {
        return newsRepository.saveAndFlush(news);
    }

    @Override
    public News update(News news) {
        return newsRepository.saveAndFlush(news);
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
    public void remove(News news) {
        newsRepository.delete(news);
    }

    public NewsRepository getNewsRepository() {
        return newsRepository;
    }

    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
