package com.epam.msfrolov.news.action;

import com.epam.msfrolov.news.dao.DaoFactory;
import com.epam.msfrolov.news.model.News;
import com.epam.msfrolov.news.form.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class NewsAction extends DispatchAction {
    private static final Logger log = LoggerFactory.getLogger(NewsAction.class);

    public ActionForward showNewsList(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        System.out.println("!showNewsList");
        NewsForm newsForm = (NewsForm) form;
        log.debug("1");
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            log.debug("2");
            List<News> newsList = daoFactory.getDao().getList();
            newsForm.setNewsList(newsList);
        }
        return mapping.findForward("show-news-list");
    }

    public ActionForward addNews(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        return mapping.findForward("add-news");
    }

    public ActionForward save(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        System.out.println("!addNews");
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        log.debug("Current news: {}", news);
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {

            News SavedObject = daoFactory.getDao().save(news);
            newsForm.setNews(SavedObject);
        }
        return mapping.findForward("show-news-list");
    }

    public ActionForward delete(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) {

        NewsForm newsForm = (NewsForm) form;
        for (int id : newsForm.getIdList()) {
            log.debug("ID: {}", id);
        }
        return mapping.findForward("delete");
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

    public ActionForward editNews(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        NewsForm newsForm = (NewsForm) form;
        log.debug("edit-news");
        return mapping.findForward("edit-news");
    }
}
