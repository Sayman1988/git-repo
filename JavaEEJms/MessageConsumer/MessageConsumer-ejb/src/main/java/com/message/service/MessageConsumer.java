package com.message.service;

import lombok.extern.slf4j.Slf4j;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Oleksandr Serogin
 */
@Slf4j
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") ,
                @ActivationConfigProperty(propertyName="connectionFactoryJndiName",propertyValue="jms/feedConnectionFactory"),
                @ActivationConfigProperty(propertyName="destinationJndiName", propertyValue="jms/feedTopic")
        }
)
public class MessageConsumer implements MessageListener {
    @Override
    public void onMessage(final Message msg) {
        try {
            TextMessage message = (TextMessage) msg;
            log.info("Message (id = {}) is received with next content: {}", message.getJMSMessageID(), message.getText());
        } catch (JMSException ex) {
            log.error("Error getting message {}", msg, ex);
        }
    }
}

