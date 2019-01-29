package com.hzh.demo.service;

import com.hzh.demo.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void send (EmailModel emailModel){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailModel.getFrom());
        message.setTo(emailModel.getTo());
        message.setText(emailModel.getText());
        message.setSubject(emailModel.getSubject());
        javaMailSender.send(message);
    }

}
