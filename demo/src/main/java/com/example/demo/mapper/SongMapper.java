<<<<<<< HEAD
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
=======
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
>>>>>>> 2a49c69d73e63c78138c64afc292d729fd1ca30f
