package com.zhzteam.zhz233.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Integer.MAX_VALUE - 1)
@WebFilter(urlPatterns = "/*",filterName = "CorsFilter")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse hsResponse = (HttpServletResponse) servletResponse;
        hsResponse.setContentType("text/json");
        hsResponse.setCharacterEncoding("UTF-8");
        hsResponse.setHeader("Access-Control-Max-Age", "1800");
        hsResponse.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, token");
        hsResponse.setHeader("Access-Control-Allow-Origin", "*");
        hsResponse.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
