package com.life.Config;

/*
 *@Author: life-0
 *@ClassName: RemoveUrlJsessionIdFilter
 *@Date: 2021/3/19 11:07
 *TODO @Description:    清除URL连带的jssessionid== 问题
 * 注解 @WebFilter(urlPatterns = "/*",filterName = "removeUrlJsessionIdFilter")相当于web.xml中的filter-mapping

 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*", filterName = "removeUrlJsessionIdFilter",servletNames={"dispatcherServlet"})
public class RemoveUrlJsessionIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // skip non-http requests
        if (request == null) {
            chain.doFilter (request, response);
            return;
        }

        //从url中删除jsessionid
        // isRequestedSessionIdFromURL():Checks whether the requested session ID came in as part of the request URL.
        if (httpServletRequest.isRequestedSessionIdFromURL ()) {
            HttpSession session = httpServletRequest.getSession ();
            if (null != session) {
                session.invalidate ();
            }
        }
        // wrap response to remove URL encoding
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper (httpServletResponse) {
            @Override
            public String encodeRedirectUrl(String url) {
                return url;
            }

            @Override
            public String encodeRedirectURL(String url) {
                return url;
            }

            @Override
            public String encodeUrl(String url) {
                return url;
            }

            @Override
            public String encodeURL(String url) {
                return url;
            }
        };
        // process next request in chain
//        add restful of ajax request in 3 lines
        wrappedResponse.setHeader ("Access-Control-Allow-Origin", "*");
        wrappedResponse.setHeader ("Access-Control-Allow-Methods","GET,POST,DELETE,PUT");
        wrappedResponse.setHeader ("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept");
        chain.doFilter (request, wrappedResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }


}