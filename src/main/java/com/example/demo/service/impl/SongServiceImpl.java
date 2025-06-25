package com.example.demo.service.impl;

import com.example.demo.dto.SongDto;
import com.example.demo.entity.Song;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.SongMapper;
import com.example.demo.repository.SongRepository;
import com.example.demo.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    @Override
    public SongDto createSong(SongDto songDto) {
        Song song = SongMapper.mapSong(songDto);
        Song savedSong = songRepository.save(song);
        return SongMapper.mapSongDto(savedSong);
    }

    @Override
    public SongDto getSongById(Long songId) {
        Song song=songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song Not Found"));
        return SongMapper.mapSongDto(song);
    }

    @Override
    public List<SongDto> getAllSongs() {
        List<Song> songs = songRepository.findAll();
        return songs.stream().map((song) -> SongMapper.mapSongDto(song)).
                collect(Collectors.toList());
    }

    @Override
    public SongDto updateSong(Long songId, SongDto updatedSong) {
        Song song=songRepository.findById(songId).orElseThrow(() ->
                new ResourceNotFoundException("Song Not Found"));
        song.setTitle(updatedSong.getTitle());
        song.setAuthor(updatedSong.getAuthor());
        song.setAlbum(updatedSong.getAlbum());
        song.setGenre(updatedSong.getGenre());
        Song updatedSongObj = songRepository.save(song);
        return SongMapper.mapSongDto(updatedSongObj);
    }

    @Override
    public void deleteSong(Long songId) {
        Song song=songRepository.findById(songId).orElseThrow(
                () -> new ResourceNotFoundException("Song Not Found"));
        songRepository.deleteById(songId);
    }

}