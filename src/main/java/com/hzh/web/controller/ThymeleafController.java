package com.hzh.web.controller;

import com.hzh.demo.model.User;
import com.hzh.demo.utils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private TestUtils testUtils;

    @RequestMapping("/test")
    public String home(@Valid User user, Errors errors, ModelMap modelMap){

        user.setName("111111111111");
        user.setPassword("ssss11");

        if (errors.hasErrors()){
            modelMap.put("user",user);
            return "thymeleaf/thymeleaftest";
        }
        else{
            return "success";
        }
    }

    @RequestMapping(value = "/post",produces = "text/html;charset=utf-8")
    public String post(@RequestParam("mess")String mess){
        testUtils.doing(mess);
        return "thymeleaf/thymeleafpost";
    }

    @RequestMapping(value = "/getUserList",produces = "application/json;charset=utf-8")
    public String getUserList(ModelMap modelMap){
        modelMap.addAttribute("model",testUtils.getUserList());
        return "jsonView";
    }

    @RequestMapping(value = "/deleteUserList",produces = "application/json;charset=utf-8")
    public String deleteUserList(ModelMap modelMap){
        System.out.println("deleteUserList(ModelMap modelMap)");
        User user = new User();
        user.setName("hzh");
        User user1 = new User();
        user1.setName("admin");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        modelMap.addAttribute("model",testUtils.deleteUserList(list));
        return "jsonView";
    }




}
