package com.epam.msfrolov.repository;

import com.epam.msfrolov.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 */

@Repository("newsRepository")
public interface NewsRepository extends JpaRepository<News, Integer> {
}
