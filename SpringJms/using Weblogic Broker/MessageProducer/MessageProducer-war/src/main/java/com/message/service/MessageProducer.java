package com.message.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by seroole on 3/31/2017.
 */

@Service
@Slf4j
public class MessageProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${topic.feed}")
    private String feedTopic;

    private int msgCounter = 0;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void send() {
        final String text = "TextMessage #" + ++msgCounter + " is intended for " + feedTopic + " and was generated on " + LocalDateTime.now().format(formatter) + ". It's empty";
        jmsTemplate.send(feedTopic, session -> session.createTextMessage(text));
        log.info(text);
    }

    public void send(String message) {
        final String text = "TextMessage #" + ++msgCounter + " is intended for " + feedTopic + " and was generated on " + LocalDateTime.now().format(formatter) + ". It contains next info: " + message;
        jmsTemplate.send(feedTopic, session -> session.createTextMessage(text));
        log.info(text);
    }
}

