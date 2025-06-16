<<<<<<< HEAD
package com.example.demo.service;

import com.example.demo.dto.SongDto;

import java.util.List;

public interface SongService {
    SongDto createSong(SongDto songDto);

    SongDto getSongById(Long song_id);

    List<SongDto> getAllSongs();

    SongDto updateSong(Long song_id, SongDto updated_song);

    void deleteSong(Long song_id);

}
=======
package com.example.demo.service;

import com.example.demo.dto.SongDto;

import java.util.List;

public interface SongService {
    SongDto createSong(SongDto songDto);

    SongDto getSongById(Long song_id);

    List<SongDto> getAllSongs();

    SongDto updateSong(Long song_id, SongDto updated_song);

    void deleteSong(Long song_id);

}
>>>>>>> 2a49c69d73e63c78138c64afc292d729fd1ca30f
