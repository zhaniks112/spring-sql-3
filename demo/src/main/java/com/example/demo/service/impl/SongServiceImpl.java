package com.example.demo.service.impl;

import com.example.demo.dto.SongDto;
import com.example.demo.entity.Song;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.SongMapper;
import com.example.demo.repository.SongRepository;
import com.example.demo.service.SongService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.RecognitionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private SongRepository songRepository;
    @Override
    public SongDto createSong(SongDto songDto) {
        Song song= SongMapper.mapSong(songDto);
        Song savedsong=songRepository.save(song);
        return SongMapper.mapSongDto(savedsong);
    }

    @Override
    public SongDto getSongById(Long song_id) {
        Song song=songRepository.findById(song_id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("There is no song with given id"));

        return SongMapper.mapSongDto(song);
    }

    @Override
    public List<SongDto> getAllSongs() {
        List<Song> songs=songRepository.findAll();
        return songs.stream().map((song)->SongMapper.mapSongDto(song))
                .collect(Collectors.toList());
    }

    @Override
    public SongDto updateSong(Long song_id, SongDto updated_song) {
        Song song=songRepository.findById(song_id).orElseThrow(
                () -> new ResourceNotFoundException("There is no song with given id")
        );

        song.setTitle(updated_song.getTitle());
        song.setAuthor(updated_song.getAuthor());
        song.setAlbum(updated_song.getAlbum());

        Song updatedSongObj=songRepository.save(song);
        return SongMapper.mapSongDto(updatedSongObj);
    }

    @Override
    public void deleteSong(Long song_id) {
        Song song=songRepository.findById(song_id).orElseThrow(
                () -> new ResourceNotFoundException("There is no song with given id")
        );

        songRepository.deleteById(song_id);
    }
}