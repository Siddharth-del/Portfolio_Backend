package com.example.app.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Service.ResumeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "https://siddharth-backend.vercel.app"})
public class ResumeController {  
     @Autowired
    private ResumeService resumeService;

    @PostMapping("/ask-question")
    public ResponseEntity<String> askQuestion(@RequestBody String question) throws IOException{
        String answer=resumeService.ask(question);
        return new ResponseEntity<>(answer,HttpStatus.OK);
    }

}
