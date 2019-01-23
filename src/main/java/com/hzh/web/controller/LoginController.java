package com.hzh.web.controller;

import com.hzh.web.exception.NotFoundException;
import com.hzh.demo.model.User;
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
            throw new NotFoundException();
            //return "login";
        }
        else{
            return "success";
        }
    }

}
