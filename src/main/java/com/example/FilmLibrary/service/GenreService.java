package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.GenreDTO;

import java.util.List;

public interface GenreService {
    GenreDTO saveGenre(GenreDTO genreDTO);
    List<GenreDTO> getAllGenre();
    GenreDTO getGenreById(Long id);
    GenreDTO updateGenre (GenreDTO genreDTO);
}
