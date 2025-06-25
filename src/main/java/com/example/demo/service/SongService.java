package com.example.demo.service;

import com.example.demo.dto.SongDto;

import java.util.List;

public interface SongService {
    SongDto createSong(SongDto songDto);

    SongDto getSongById(Long songId);

    List<SongDto> getAllSongs();

    SongDto updateSong(Long songId, SongDto updated_song);

    void deleteSong(Long songId);
}
