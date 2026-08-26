package com.example.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Value("${contact.mailto}")
    private String mailto;

    public void sendMail(String sendermail, String body, String name) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Portfolio Contact-"+name);
            message.setTo(mailto);
        
            message.setText(
                            "Message:\n\n" + body+
                            "\n\nName: " + name +
                            "\nEmail: " + sendermail );
            message.setFrom("GautamSiddharth131004@gmail.com");
            message.setReplyTo(sendermail);
            mailSender.send(message);
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
