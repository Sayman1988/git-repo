package com.message.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;

/**
 * @author Oleksandr Serogin
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    private String destinationQueue;

    @Test
    public void receive() throws InterruptedException, JMSException {
        jmsTemplate.send(destinationQueue, session -> session.createTextMessage("Test Message"));
        Thread.sleep(1000L);
    }
}
