package com.hzh.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

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
        modelAndView.setViewName("home");
       /* Locale locale = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse().getLocale();
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.ENGLISH);
        Locale locale1 = LocaleContextHolder.getLocale();
        System.out.println(locale.hashCode());
        System.out.println(locale1.hashCode());*/
        //SessionAttributeStore
        //RequestMappingHandlerAdapter
        //CallableMethodReturnValueHandler
        //ServletInvocableHandlerMethod
        //StandardServletAsyncWebRequest
        //WebAsyncManager
       //WebAsyncTask
        return modelAndView;
    }


    @RequestMapping("/name")
    public String name(@ModelAttribute("name") String name){
        return "home";
    }


    @RequestMapping(value = "asyncmethod",produces = "text/html;charset=utf-8" )
    public Callable<ResponseEntity<String>> asyncmethod(HttpServletResponse response){
        return new Callable<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> call() throws Exception {
                Thread.sleep(20000);
                return new ResponseEntity<>("哔哩哔哩",HttpStatus.OK);
            }
        };
    }

}
