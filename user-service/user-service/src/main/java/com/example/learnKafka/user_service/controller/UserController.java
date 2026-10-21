package com.example.learnKafka.user_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<String, String > kafkaTemplates;

    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {

              kafkaTemplates.send("user-random-topic",message);

    return ResponseEntity.ok("Message queues");
    }
}
