package com.message.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author Oleksandr Serogin
 */

@Service
@Slf4j
public class MessageProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    private String destinationQueue;

    private int msgCounter = 0;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void send() {
        final String text = "TextMessage #" + ++msgCounter + " is intended for " + destinationQueue + " and was generated on " + LocalDateTime.now().format(formatter) + ". It's empty";
        jmsTemplate.send(destinationQueue, session -> session.createTextMessage(text));
        log.info(text);
    }

    public void send(String message) {
        final String text = "TextMessage #" + ++msgCounter + " is intended for " + destinationQueue + " and was generated on " + LocalDateTime.now().format(formatter) + ". It contains next info: " + message;
        jmsTemplate.send(destinationQueue, session -> session.createTextMessage(text));
        log.info(text);
        //TEST Branch commmit
    }
}

