package com.epam.msfrolov.repository;

import com.epam.msfrolov.model.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("newsRepository")
public interface NewsRepository extends CrudRepository<News, Integer> {
}
