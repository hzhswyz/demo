package com.hzh.web.controller;

import com.hzh.demo.model.EmailModel;
import com.hzh.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "send",method = RequestMethod.POST)
    public ResponseEntity<String> sendEmail(EmailModel emailModel){

        emailService.send(emailModel);
        return new ResponseEntity<>("Send Successful!",HttpStatus.OK);
    }

    @RequestMapping
    public String email(ModelMap modelMap){
        EmailModel emailModel = new EmailModel();
        modelMap.addAttribute("emailmodel",emailModel);
        return "jsp/email";
    }
}
