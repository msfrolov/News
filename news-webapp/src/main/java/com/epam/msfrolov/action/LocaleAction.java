package com.epam.msfrolov.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LocaleAction extends DispatchAction {

    private static final String LOCALE = "org.apache.struts.action.LOCALE";
    private static final Locale RUSSIAN = new Locale("ru", "RU");
    private static final Locale ENGLISH = Locale.ENGLISH;
    private static final String SUCCESS = "success";

    public ActionForward english(ActionMapping mapping, ActionForm ignoredForm, HttpServletRequest request, HttpServletResponse ignoredResponse) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute(LOCALE, ENGLISH);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward russian(ActionMapping mapping, ActionForm ignoredForm, HttpServletRequest request, HttpServletResponse ignoredResponse) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute(LOCALE, RUSSIAN);
        return mapping.findForward(SUCCESS);
    }
}
