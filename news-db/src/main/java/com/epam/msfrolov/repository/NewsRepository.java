package com.epam.msfrolov.repository;

import com.epam.msfrolov.model.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 */

@Repository("newsRepository")
public interface NewsRepository extends CrudRepository<News, Integer> {

//    void deleteFromNewsWhereIdIn(List<Integer> newsList);

//    void deleteById(int[] idList);
}
