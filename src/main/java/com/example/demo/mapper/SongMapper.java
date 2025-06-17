package com.example.demo.mapper;

import com.example.demo.dto.SongDto;
import com.example.demo.entity.Song;

public class SongMapper {
    public static SongDto mapSongDto(Song song) {
        return new SongDto(
                song.getId(),
                song.getTitle(),
                song.getAuthor(),
                song.getAlbum(),
                song.getGenre()
        );
    }

    public static Song mapSong(SongDto songDto) {
        return new Song(
                songDto.getId(),
                songDto.getTitle(),
                songDto.getAuthor(),
                songDto.getAlbum(),
                songDto.getGenre()
        );
    }
}
