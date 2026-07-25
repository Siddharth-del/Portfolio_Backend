package com.example.app.Service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ResumeService {

    private final ChatClient chatClient;
    private final Resource resumePrompt ;

    public ResumeService(@Qualifier("openAiChatClient") ChatClient chatClient,
            @Value("classpath:prompts/resume.txt") Resource resumePrompt) {
        this.chatClient = chatClient;
        this.resumePrompt = resumePrompt;
    }
    
  
    public String ask(String question) throws IOException {
        String context = resumePrompt.getContentAsString(StandardCharsets.UTF_8);
        return chatClient
                .prompt()
                .system(context)
                .user(question)
                .call()
                .content();
    }
}
