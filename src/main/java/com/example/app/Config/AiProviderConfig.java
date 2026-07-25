package com.example.app.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiProviderConfig {
    
    @Bean("openAiChatClient")
   ChatClient openAiChatClient(OpenAiChatModel chatModel){
    return ChatClient.builder(chatModel).build();
   }
}
