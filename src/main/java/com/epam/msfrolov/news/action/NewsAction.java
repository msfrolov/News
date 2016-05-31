package com.epam.msfrolov.news.action;

import com.epam.msfrolov.news.db.dao.DaoFactory;
import com.epam.msfrolov.news.exception.AppException;
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

public class NewsAction extends DispatchAction {

    private static final Logger log = LoggerFactory.getLogger(NewsAction.class);

    public ActionForward showNewsList(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            newsForm.setNewsList(daoFactory.getDao().getList());
        } catch (Exception e) {
            throw new AppException("failed to to call a method showNewsList");
        }
        return mapping.findForward("show-news-list");
    }

    public ActionForward viewNews(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            newsForm.setNews(daoFactory.getDao().findById(newsForm.getIdNews()));
        } catch (Exception e) {
            throw new AppException("failed to to call a method viewNews");
        }
        return mapping.findForward("view-news");
    }

    public ActionForward addNews(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setDate(new Date());
        newsForm.setNews(news);
        return mapping.findForward("add-news");
    }

    public ActionForward editNews(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            News foundObject = daoFactory.getDao().findById(newsForm.getIdNews());
            newsForm.setNews(foundObject);
            newsForm.setIdNews(foundObject.getId());
        } catch (Exception e) {
            throw new AppException("failed to to call a method editNews");
        }
        return mapping.findForward("edit-news");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            News savedObject = daoFactory.getDao().save(news);
            newsForm.setNews(savedObject);
            newsForm.setIdNews(savedObject.getId());
        } catch (Exception e) {
            throw new AppException("failed to to call a method save");
        }
        return mapping.findForward("view-news");
    }

    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            News SavedObject = daoFactory.getDao().update(news);
            newsForm.setNews(SavedObject);
        } catch (Exception e) {
            throw new AppException("failed to to call a method update");
        }
        return mapping.findForward("view-news");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        try (DaoFactory daoFactory = DaoFactory.newInstance()) {
            daoFactory.getDao().remove(newsForm.getIdArray());
        } catch (Exception e) {
            throw new AppException("failed to to call a method delete");
        }
        return mapping.findForward("delete");
    }
}
