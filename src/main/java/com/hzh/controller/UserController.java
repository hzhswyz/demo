package com.hzh.controller;

import com.hzh.model.User;
import com.hzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("GetUserByID")
    public String GetUserByID(@RequestParam("id") String id, ModelMap modelMap){
        User user = userService.GetUserByID(id);
        modelMap.put("user",user);
        return "home.jsp";
    }
}
