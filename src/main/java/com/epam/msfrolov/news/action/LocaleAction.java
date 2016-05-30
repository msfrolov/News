package com.epam.msfrolov.news.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LocaleAction extends DispatchAction {

    private static final Locale RUSSIA = new Locale("ru", "RU");
    private static final String SUCCESS = "success";

    //parameters request and response must be present
    public ActionForward english(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("org.apache.struts.action.LOCALE", Locale.ENGLISH);
        return mapping.findForward(SUCCESS);
    }

    //view the comment above
    public ActionForward russian(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("org.apache.struts.action.LOCALE", RUSSIA);
        return mapping.findForward(SUCCESS);
    }
}
