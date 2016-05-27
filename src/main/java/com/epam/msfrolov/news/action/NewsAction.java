package com.epam.msfrolov.news.action;

import com.epam.msfrolov.news.dao.DaoFactory;
import com.epam.msfrolov.news.form.NewsForm;
import com.epam.msfrolov.news.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


public class NewsAction extends DispatchAction {
    private static final Logger log = LoggerFactory.getLogger(NewsAction.class);

    public ActionForward showNewsList(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            List<News> newsList = daoFactory.getDao().getList();
            newsForm.setNewsList(newsList);
        }
        return mapping.findForward("show-news-list");
    }

    public ActionForward viewNews(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        int idNews = newsForm.getIdNews();
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            News foundObject = daoFactory.getDao().findById(idNews);
            newsForm.setNews(foundObject);
        }
        log.debug("view-news");
        return mapping.findForward("view-news");
    }

    public ActionForward addNews(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        Date date = new Date();
        log.debug("New date: {}", date);
        news.setDate(date);
        newsForm.setNews(news);
        return mapping.findForward("add-news");
    }

    public ActionForward editNews(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        int idNews = newsForm.getIdNews();
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            News foundObject = daoFactory.getDao().findById(idNews);
            newsForm.setNews(foundObject);
            newsForm.setIdNews(foundObject.getId());
        }
        return mapping.findForward("edit-news");
    }

    public ActionForward save(ActionMapping mapping,
                              ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        log.debug("Current news: {}", news);
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            News savedObject = daoFactory.getDao().save(news);
            newsForm.setNews(savedObject);
            newsForm.setIdNews(savedObject.getId());
        }
        return mapping.findForward("view-news");
    }

    public ActionForward update(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            News SavedObject = daoFactory.getDao().update(news);
            newsForm.setNews(SavedObject);
        }
        return mapping.findForward("view-news");
    }

    public ActionForward delete(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) {

        NewsForm newsForm = (NewsForm) form;
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            int removedObjects = daoFactory.getDao().remove(newsForm.getIdArray());
        }
        return mapping.findForward("delete");
    }
}
