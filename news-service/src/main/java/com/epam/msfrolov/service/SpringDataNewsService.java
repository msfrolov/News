package com.epam.msfrolov.service;

import com.epam.msfrolov.model.News;
import com.epam.msfrolov.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class SpringDataNewsService implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public SpringDataNewsService() {
    }

    @Override
    public List<News> getList() {
        List<News> newsList = new ArrayList<>();
        Iterable<News> newsIterable = newsRepository.findAll();
        Iterator<News> iterator = newsIterable.iterator();
        while (iterator.hasNext()) {
            newsList.add(iterator.next());
        }
        return newsList;
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
