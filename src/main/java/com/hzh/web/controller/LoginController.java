package com.hzh.web.controller;

import com.hzh.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping("/userlogin")
    public String userlogin(@Valid User user, Errors errors, ModelMap modelMap){

        if (errors.hasErrors()){
            modelMap.put("user",user);
            //throw new NotFoundException();
            return "jsp/login";
        }
        else{
            return "jsp/success";
        }
    }

    @RequestMapping("/login")
    public String login(){
        return "thymeleaf/login";
    }

}
