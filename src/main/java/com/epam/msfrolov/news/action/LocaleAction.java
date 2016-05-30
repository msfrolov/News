package com.epam.msfrolov.news.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/**
 *
 */
public class LocaleAction extends DispatchAction {

    private static final Locale RUSSIA = new Locale("ru", "RU");
    private static final String LOCALE = "org.apache.struts.action.LOCALE";
    private final static String SUCCESS = "success";

    //
    // TODO: Get rid of unnecessary params: form, response.
    //
    public ActionForward english(ActionMapping mapping, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute(LOCALE, ENGLISH);
        return mapping.findForward(SUCCESS);
    }

    //
    // TODO: See above comment.
    //
    public ActionForward russian(ActionMapping mapping, ActionForm  form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute(LOCALE, RUSSIA);
        return mapping.findForward(SUCCESS);
    }
}
