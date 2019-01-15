package com.hzh.controller;

import com.sun.tracing.dtrace.Attributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller
@SessionAttributes("name")
public class MainController {

    @ModelAttribute("name")
    public String initname(){
        return "hhhzzzhhh";
    }

    @RequestMapping("/")
    public ModelAndView index(){
        //DispatcherServlet
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.jsp");
       /* Locale locale = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse().getLocale();
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.ENGLISH);
        Locale locale1 = LocaleContextHolder.getLocale();
        System.out.println(locale.hashCode());
        System.out.println(locale1.hashCode());*/
        //SessionAttributeStore

        return modelAndView;
    }


    @RequestMapping("/name")
    public String name(@ModelAttribute("name") String name){
        return "home";
    }

}
