package com.hzh.web.controller;

import com.hzh.demo.model.EmailModel;
import com.hzh.demo.model.Rvi;
import com.hzh.demo.model.User;
import com.hzh.demo.service.EmailService;
import com.hzh.demo.service.RviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.UUID;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private RviService rviService;

    @RequestMapping(value = "/email/send",method = RequestMethod.POST)
    public ResponseEntity<String> sendEmail(String to, @AuthenticationPrincipal Principal principal){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        EmailModel emailModel = new EmailModel();
        emailModel.setTo(to);
        emailModel.setText("尊敬的:"+principal.getName()+" 用户，请点击链接激活账号："+"http://localhost/validation?code="+uuid);
        try {
            emailService.send(emailModel);
        }
        catch (Exception e){
            return new ResponseEntity<>("Fail in send!",HttpStatus.OK);
        }
        Rvi rvi = new Rvi();
        rvi.setUserid(principal.getName());
        rvi.setVerificationCode(uuid);
        rviService.insert(rvi);
        return new ResponseEntity<>("Send Successful!",HttpStatus.OK);
    }

    @RequestMapping("/email")
    public String email(ModelMap modelMap){
        EmailModel emailModel = new EmailModel();
        modelMap.addAttribute("emailmodel",emailModel);
        return "jsp/email";
    }

    @RequestMapping("/register")
    public String register(){
        return "jsp/register";
    }

    @RequestMapping("/validation")
    public ResponseEntity<String> validationInformation(@AuthenticationPrincipal Principal principal, @RequestParam("code")String code){
        rviService.validationInformation(principal.getName(),code);
        return new ResponseEntity<>("Send Successful!",HttpStatus.OK);
    }

}
