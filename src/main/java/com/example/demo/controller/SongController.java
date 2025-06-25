package com.example.demo.controller;

import com.example.demo.dto.SongDto;
import com.example.demo.service.SongService;
import java.util.List;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/songs")
@Controller
public class SongController {
    private final SongService songService;

    @Generated
    public SongController(SongService songService) {
        this.songService = songService;
    }

    // Изменён путь, чтобы избежать конфликта
    @GetMapping("/page/{login}")
    public String getSongs(@PathVariable String login, Model model) {
        model.addAttribute("userLogin", login);
        return "song_page";
    }

    @PostMapping
    public ResponseEntity<SongDto> createSong(@RequestBody SongDto songDto) {
        SongDto savedSong = this.songService.createSong(songDto);
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDto> getSongById(@PathVariable("id") Long songId) {
        SongDto songDto = this.songService.getSongById(songId);
        return ResponseEntity.ok(songDto);
    }

    @GetMapping
    public ResponseEntity<List<SongDto>> getAllSongs() {
        List<SongDto> songs = this.songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongDto> updateSong(@PathVariable("id") Long songId, @RequestBody SongDto updatedSong) {
        SongDto songDto = this.songService.updateSong(songId, updatedSong);
        return ResponseEntity.ok(songDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable("id") Long songId) {
        this.songService.deleteSong(songId);
        return ResponseEntity.ok("Song deleted successfully");
    }
}
