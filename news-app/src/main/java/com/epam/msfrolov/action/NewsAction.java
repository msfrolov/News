package com.epam.msfrolov.action;

import com.epam.msfrolov.form.NewsForm;
import com.epam.msfrolov.model.News;
import com.epam.msfrolov.service.NewsService;
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

    private static final Logger _LOG = LoggerFactory.getLogger(NewsAction.class);
    private NewsService service = new NewsService();

    public ActionForward showNewsList(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNewsList(service.getList());
        return mapping.findForward("show-news-list");
    }

    public ActionForward viewNews(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNews(service.findById(newsForm.getIdNews()));
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
        News foundObject = service.findById(newsForm.getIdNews());
        newsForm.setNews(foundObject);
        newsForm.setIdNews(foundObject.getId());
        return mapping.findForward("edit-news");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        News savedObject = service.save(news);
        newsForm.setNews(savedObject);
        newsForm.setIdNews(savedObject.getId());
        return mapping.findForward("view-news");
    }

    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        News SavedObject = service.update(news);
        newsForm.setNews(SavedObject);
        return mapping.findForward("view-news");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest ignoredRequest, HttpServletResponse ignoredResponse) {
        NewsForm newsForm = (NewsForm) form;
        service.remove(newsForm.getIdArray());
        return mapping.findForward("delete");
    }
}
