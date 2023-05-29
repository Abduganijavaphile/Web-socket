package com.cleancode.websocet;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestComponent {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public TestComponent(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Scheduled(fixedRate = 5000L)
    public void getDate(){
        Date date = new Date();
        simpMessagingTemplate.convertAndSend("/topic/date", date);
    }
    public void typing(String message){
        simpMessagingTemplate.convertAndSend("/topic/type", "Typing...");
    }
    public void keydown(String message){
        simpMessagingTemplate.convertAndSend("/topic/keydown", "Message");
    }
}
