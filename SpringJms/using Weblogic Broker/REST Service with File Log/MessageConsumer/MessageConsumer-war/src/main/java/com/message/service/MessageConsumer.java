package com.message.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by seroole on 3/31/2017.
 */

@Service
@Slf4j
class MessageConsumer {
    @JmsListener(destination = "${topic.feed}")
    public void receive(final TextMessage message){
        try {
            log.info("Message (id = " + message.getJMSMessageID() + ") is received with next content: " + message.getText());
        } catch (JMSException e) {
            log.error("Error getting message {}", message, e);
        }
    }
}

