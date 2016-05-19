package com.epam.msfrolov.news.presentation.action;

import com.epam.msfrolov.news.model.News;
import com.epam.msfrolov.news.presentation.form.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class NewsAction extends DispatchAction {
    public ActionForward showNewsList(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        System.out.println("!showNewsList");
        NewsForm newsForm = (NewsForm) form;

        List<News> newsList = getNewsList();
        newsForm.setNewsList(newsList);
        request.setAttribute("newsList", newsList);

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


}
