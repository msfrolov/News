package com.epam.msfrolov.service;

import com.epam.msfrolov.exception.AppException;
import com.epam.msfrolov.model.News;
import com.epam.msfrolov.util.FileUtil;

import java.util.List;

public interface NewsService {

    static NewsService newInstance() {
        String serviceImplementName = FileUtil.getProperties("properties/service.properties").getProperty("service.name");
        try {
            return (NewsService) Class.forName(serviceImplementName).newInstance();
        } catch (ClassNotFoundException e) {
            throw new AppException("Class NewsService not found", e);
        } catch (InstantiationException e) {
            throw new AppException("Class NewsService factory not init", e);
        } catch (IllegalAccessException e) {
            throw new AppException("Illegal access on some extended NewsService not found", e);
        } catch (Exception e) {
            throw new AppException("Failed to get NewsService instance", e);
        }
    }

    List<News> getList();

    News findById(int id);

    News save(News news);

    News update(News news);

    int remove(int[] idArray);

    boolean remove(int id);

    News remove(News news);
}
