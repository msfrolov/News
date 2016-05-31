package com.epam.msfrolov.news.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharEncodingFilter implements Filter {

    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING);
        response.setContentType(CONTENT_TYPE);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
