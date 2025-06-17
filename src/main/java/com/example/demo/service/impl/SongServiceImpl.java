package com.example.demo.service.impl;

import com.example.demo.dto.SongDto;
import com.example.demo.service.SongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private List<SongDto> songList = new ArrayList<>();

    @Override
    public SongDto createSong(SongDto songDto) {
        songList.add(songDto);
        return songDto;
    }

    @Override
    public SongDto getSongById(Long songId) {
        return songList.stream()
                .filter(song -> song.getId().equals(songId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<SongDto> getAllSongs() {
        return new ArrayList<>(songList);
    }

    @Override
    public SongDto updateSong(Long songId, SongDto updatedSong) {
        SongDto existingSong = getSongById(songId);
        if (existingSong != null) {
            int index = songList.indexOf(existingSong);
            songList.set(index, updatedSong);
            return updatedSong;
        }
        return null;
    }

    @Override
    public void deleteSong(Long songId) {
        songList.removeIf(song -> song.getId().equals(songId));
    }
}