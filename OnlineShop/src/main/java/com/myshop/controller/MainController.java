package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Oleksandr Serogin
 */
@Controller
public class MainController {
    @RequestMapping("/greeting")
    public String greeting(Model model) {
        return "greeting";
    }
}
