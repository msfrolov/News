package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;
import com.epam.msfrolov.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("newsService")
@Repository
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
//        List<News> newsList = new ArrayList<>();
//        newsRepository.findAll().forEach(newsList::add);
//        return newsList;
        return new ArrayList<>();
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
}
