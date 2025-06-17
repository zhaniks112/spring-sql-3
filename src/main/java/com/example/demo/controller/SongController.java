package com.example.demo.controller;


import com.example.demo.dto.SongDto;
import com.example.demo.service.SongService;
import java.util.List;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/songs"})
public class SongController {
    private SongService songService;

    @PostMapping
    public ResponseEntity<SongDto> createSong(@RequestBody SongDto songDto) {
        SongDto savedSong = this.songService.createSong(songDto);
        return new ResponseEntity(savedSong, HttpStatus.CREATED);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<SongDto> getSongById(@PathVariable("id") Long song_id) {
        SongDto songDto = this.songService.getSongById(song_id);
        return ResponseEntity.ok(songDto);
    }

    @GetMapping
    public ResponseEntity<List<SongDto>> getAllSongs() {
        List<SongDto> songs = this.songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @PutMapping({"{id}"})
    public ResponseEntity<SongDto> updateSong(@PathVariable("id") Long song_id, @RequestBody SongDto updated_song) {
        SongDto songDto = this.songService.updateSong(song_id, updated_song);
        return ResponseEntity.ok(songDto);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteSong(@PathVariable("id") Long song_id) {
        this.songService.deleteSong(song_id);
        return ResponseEntity.ok("Song deleted successfully");
    }

    @Generated
    public SongController(final SongService songService) {
        this.songService = songService;
    }
}
