package com.hzh.controller;

import com.hzh.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping()
    public String login(@Valid User user, Errors errors, ModelMap modelMap){

        if (errors.hasErrors()){
            modelMap.put("user",user);
            return "login";
        }
        else{
            return "success";
        }
    }

}
