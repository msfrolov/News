package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;
import com.epam.msfrolov.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
//@Transactional
//@Lazy
@Repository("newsService")
public class NewsServiceImpl implements NewsService {

    //    @Qualifier("newsRepository")
    @Autowired
    private NewsRepository newsRepository;

    public NewsServiceImpl() {
    }

    @Override
    public List<News> getAll() {
        List<News> newsList = new ArrayList<>();
        newsRepository.findAll().forEach(newsList::add);
        return newsList;
//        return new ArrayList<>();
    }

    @Override
    public News findById(int id) {
        return newsRepository.findOne(id);
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News update(News news) {
        return null;
    }

    @Override
    public void remove(int[] idArray) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void remove(News news) {

    }

    public NewsRepository getNewsRepository() {
        return newsRepository;
    }

    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
