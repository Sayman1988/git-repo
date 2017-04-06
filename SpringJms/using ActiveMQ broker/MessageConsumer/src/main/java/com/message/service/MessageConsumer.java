package com.message.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author Oleksandr Serogin
 */

@Service
@Slf4j
class MessageConsumer {
    @JmsListener(destination = "${jms.queue.destination}")
    public void receive(final TextMessage message){
        try {
            log.info("Message (id = " + message.getJMSMessageID() + ") is received with next content: " + message.getText());
        } catch (JMSException e) {
            log.error("Error getting message {}", message, e);
        }
    }
}

