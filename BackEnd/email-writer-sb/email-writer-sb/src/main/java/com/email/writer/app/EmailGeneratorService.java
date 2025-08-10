package com.email.writer.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService(WebClient.Builder webClientBuilder){
        this.webClient=webClientBuilder.build();
    }


    public String generateEmailReply(EmailRequest emailRequest){
        //build the prompt for the AI model
        String prompt = buildPrompt(emailRequest);

        //Craft a Request
        Map<String,Object> requestBody=Map.of(
            "contents",new Object[]{
                Map.of("parts",new Object[]{
                    Map.of("text",prompt)
                })
            }
        );
        //Do Request and Get Response
        String response=webClient.post()
                .uri(geminiApiUrl +"?key="+ geminiApiKey)
                .header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //Extract Response and Return
        return extractResponseContent(response);
    }
    private String extractResponseContent(String response){
        try{
            ObjectMapper mapper=new ObjectMapper();
            JsonNode rootNode=mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        }
        catch(Exception e){
            return "Error Processing request: "+e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a Professional Email Reply for the following email content. Please don't generate a subject line ");
        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("use a ").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
        
    }

}
