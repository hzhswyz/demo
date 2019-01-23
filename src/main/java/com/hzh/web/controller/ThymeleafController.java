package com.hzh.web.controller;

import com.hzh.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/test")
    public String home(@Valid User user, Errors errors, ModelMap modelMap){

        user.setName("111111111111");
        user.setPassword("ssss11");

        if (errors.hasErrors()){
            modelMap.put("user",user);
            return "thymeleaftest";
        }
        else{
            return "success";
        }
    }

}
