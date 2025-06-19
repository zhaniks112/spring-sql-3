package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongList {
    @GetMapping
    public String getSongPage(Model model, String login) {
        model.addAttribute("userLogin", login);
        return "song_page";
    }
}
