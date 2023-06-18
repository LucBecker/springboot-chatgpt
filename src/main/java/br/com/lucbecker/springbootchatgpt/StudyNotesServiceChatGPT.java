package br.com.lucbecker.springbootchatgpt;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import reactor.core.publisher.Mono;

@Service
public class StudyNotesServiceChatGPT {

    private WebClient webClient;

    public StudyNotesServiceChatGPT(WebClient.Builder builder) {
        this.webClient = builder
        .baseUrl("https://api.openai.com/v1/completions")
        .defaultHeader("Content-Type", "application/json")
        .defaultHeader("Authorization", String.format"(Bearer %s", apiKey))
        .build();
    }

    public Mono<ChatGPTResponse> createStudyNotes(String topic){
        ChatGPTRequest request = createStudyRequest(topic);


    }

    private ChatGPTRequest createStudyRequest(String topic) {
        String question = "Quais são os pontos chaves que devo estudar sobre o seguinte assunto: "
        + topic;

        return new ChatGPTRequest("text-davinci-003", question, 
        0.3, 2000, 1.0, 0.0, 0.0);
    }
}

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
record ChatGPTRequest(String model, String prompt,
    Double temperature, Integer maxTokens, Double topP,
    Double frequencyPenalty, Double presencePenalty){

}

record ChatGPTResponse(List<Choice> choices) {
}

record Choice(String text){
}
