package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    @GetMapping
    public String getHomePage() {
        return "home_page";
    }

    @PostMapping("/login")
    public RedirectView login(@RequestParam String login, @RequestParam String email) {
        if (login != null && !login.isEmpty() && email != null && !email.isEmpty()) {
            return new RedirectView("/songs/" + login);
        }

        return new RedirectView("/home");
    }
}