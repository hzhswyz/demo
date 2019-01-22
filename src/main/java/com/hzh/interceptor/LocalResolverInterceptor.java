package com.hzh.interceptor;


import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocalResolverInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(LocalResolverInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getParameter("local")!=null && !request.getParameter("local").equals("")){
            String localParameter = request.getParameter("local");
            Locale locale;
            switch (localParameter){
                case "en":locale = Locale.US;break;
                case "china":locale = Locale.CHINA;break;
                default:locale = Locale.CHINA;
            }
            try {
                ((LocaleResolver)((WebApplicationContext)request.getSession().getServletContext().
                        getAttribute(FrameworkServlet.SERVLET_CONTEXT_PREFIX+"dispatcher")).getBean("localeResolver"))
                        .setLocale(request,response,locale);
            }
            catch (Exception e){
                logger.error("Current LocaleResolver can't set locale,please change LocaleResolver strategy");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
