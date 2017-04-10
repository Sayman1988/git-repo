package com.message.service.controller;

import com.message.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oleksandr Serogin
 */
@RestController
public class Controller {
    @Autowired
    private MessageProducer messageProducer;

    @RequestMapping("/send")
    public String sendMessage() {
        messageProducer.send();
        return "The TextMessage without content was sent successfully!";
    }

    @RequestMapping("/send/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        messageProducer.send(message);
        return "The TextMessage with content was sent successfully!";
    }
}

