package com.epam.msfrolov.news.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(filterName = "0CharEncodingFilter", urlPatterns = "/*")
public class CharEncodingFilter implements Filter {

    public static final String ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}
