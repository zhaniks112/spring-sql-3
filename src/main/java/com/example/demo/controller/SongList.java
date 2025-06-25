package com.example.demo.controller;

import com.example.demo.dto.SongDto;
import com.example.demo.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongList {
    private final SongService songService;

    public SongList(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public String getSongPage(Model model, String login) {
        model.addAttribute("userLogin", login);
        model.addAttribute("songs", songService.getAllSongs()); // Добавляем список песен
        return "song_page";
    }

    @GetMapping("/songs/add")
    public String getAddSong(Model model) {
        model.addAttribute("NewSong", new SongDto());
        return "add_song";
    }

    @PostMapping("/songs/added")
    public String addSong(@ModelAttribute SongDto songDto) {
        songService.createSong(songDto);
        return "redirect:/songs";
    }

}
