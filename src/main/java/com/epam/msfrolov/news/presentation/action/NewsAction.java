package com.epam.msfrolov.news.presentation.action;

import com.epam.msfrolov.news.model.News;
import com.epam.msfrolov.news.presentation.form.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class NewsAction extends DispatchAction {
    private static final Logger log = LoggerFactory.getLogger(NewsAction.class);
    public ActionForward showNewsList(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        System.out.println("!showNewsList");
        NewsForm newsForm = (NewsForm) form;

        List<News> newsList = getNewsList();
        newsForm.setNewsList(newsList);
        return mapping.findForward("show-news-list");
    }

    private List<News> getNewsList() {
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            News news = new News();
            news.setId(i + 1);
            news.setTitle("title");
            news.setDate(LocalDate.now());
            news.setBrief("brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief" +
                    " brief brief brief brief brief brief brief brief brief brief brief brief brief " +
                    " brief Final.");
            newsList.add(news);
        }
        return newsList;
    }

    public ActionForward addNews(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        System.out.println("!addNews");
        return mapping.findForward("add-news");
    }

    public ActionForward delete(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response){

        NewsForm newsForm = (NewsForm) form;
        for (int id:newsForm.getIdList()) {
            log.debug("ID: {}", id);
        }
        return mapping.findForward("delete");
    }

    public ActionForward viewNews(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response){

        NewsForm newsForm = (NewsForm) form;
            log.debug("view-news");
        return mapping.findForward("view-news");
    }

    public ActionForward editNews(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response){

        NewsForm newsForm = (NewsForm) form;
            log.debug("edit-news");
        return mapping.findForward("edit-news");
    }
}
