package com.message.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Oleksandr Serogin
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private MessageProducer messageProducer;

    @Test
    public void sendSimpleMessage() throws InterruptedException, JMSException {
        this.messageProducer.send();
        Thread.sleep(1000L);
        assertThat(this.outputCapture.toString().contains("It's empty")).isTrue();
    }

    @Test
    public void sendTestMessage() throws InterruptedException, JMSException {
        this.messageProducer.send("Test message");
        Thread.sleep(1000L);
        assertThat(this.outputCapture.toString().contains("Test message")).isTrue();
    }
}
