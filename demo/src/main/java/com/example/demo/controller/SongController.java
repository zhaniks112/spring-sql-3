package com.example.demo.controller;

import com.example.demo.dto.SongDto;
import com.example.demo.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/songs")
public class SongController {
    private SongService songService;

    @PostMapping
    public ResponseEntity<SongDto> createSong(@RequestBody SongDto songDto) {
        SongDto savedSong = songService.createSong(songDto);
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SongDto> getSongById(@PathVariable("id") Long song_id) {
        SongDto songDto=songService.getSongById(song_id);
        return ResponseEntity.ok(songDto);
    }

    @GetMapping
    public ResponseEntity<List<SongDto>> getAllSongs() {
        List<SongDto> songs=songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @PutMapping("{id}")
    public ResponseEntity<SongDto> updateSong(@PathVariable("id") Long song_id,
                                              @RequestBody SongDto updated_song) {
        SongDto songDto=songService.updateSong(song_id, updated_song);
        return ResponseEntity.ok(songDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSong(@PathVariable("id") Long song_id) {
        songService.deleteSong(song_id);
        return ResponseEntity.ok("Song deleted successfully");
    }
}
