package com.hexaware.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
 
@RestController
@RequestMapping("/api/genai")
public class OpenAIController {
 
    private final String OPENAI_API_VERSION = System.getenv("OPENAI_API_VERSION");
    private final String AZURE_OPENAI_ENDPOINT = System.getenv("AZURE_OPENAI_ENDPOINT");
    private final String AZURE_OPENAI_API_KEY = System.getenv("AZURE_OPENAI_API_KEY");
 
    @GetMapping("/ask")
    public String askOpenAI() {
        RestTemplate restTemplate = new RestTemplate();
        String url = AZURE_OPENAI_ENDPOINT + "/chat/completions";
 
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + AZURE_OPENAI_API_KEY);
        headers.set("Content-Type", "application/json");
 
        String requestBody = "{ \"model\": \"gpt-40\", \"messages\": [{\"role\": \"system\", \"content\": \"You are an AI assistant.\"}, {\"role\": \"user\", \"content\": \"What is LLM?\"}], \"temperature\": 0.7, \"max_tokens\": 256, \"top_p\": 0.6, \"frequency_penalty\": 8.7 }";
 
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
 
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
 
        return response.getBody();
    }
}
