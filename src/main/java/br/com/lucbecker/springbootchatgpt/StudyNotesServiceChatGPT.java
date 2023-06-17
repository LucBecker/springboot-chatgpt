package br.com.lucbecker.springbootchatgpt;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class StudyNotesServiceChatGPT {

    public Mono<ChatGPTResponse> createStudyNotes(String topic){

    }
    
}

record ChatGPTResponse() {
    
}
