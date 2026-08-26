package com.example.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Service.EmailService;
import com.example.app.dtos.ContactDTO;

@RestController
@RequestMapping("/api/contact")
public class EmailController {
    
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> contact(@RequestBody ContactDTO contact){
        emailService.sendMail(contact.getEmail(), contact.getMessage(), contact.getName());
        return new ResponseEntity<>("Message Sent",HttpStatus.OK);
    }
}
