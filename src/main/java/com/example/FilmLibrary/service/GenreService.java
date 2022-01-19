package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.DTO.GenreDTO;
import com.example.FilmLibrary.entity.Film;
import com.example.FilmLibrary.entity.Genre;
import com.example.FilmLibrary.mapper.FilmMapper;
import com.example.FilmLibrary.mapper.GenreMapper;
import com.example.FilmLibrary.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;


    public Genre saveGenre(Genre genre) {
        return   genreRepository.save(genre);
    }

    public List<Genre> saveGenres(List<Genre> genres) {
        return genreRepository.saveAll(genres);
    }

    public List<Genre> getGenre() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre getGenreByCategory(String category) {
        return genreRepository.findByCategory(category);
    }

    public Genre updateGenre (Genre genre) {
        Genre existingGenre = genreRepository.findById(genre.getId()).orElse(null);
        existingGenre.setCategory (genre.getCategory());
        return genreRepository.save(existingGenre);
    }

    public List<GenreDTO> getAllGenreWithFilm() {
       List<GenreDTO> genreDTOList=new ArrayList<>();
        List<Genre> genreList = (genreRepository.findAll());
        for (Genre genre : genreList) {
            genreDTOList.add(GenreMapper.Genre_MAPPER.fromGenre(genre));
        }
        return genreDTOList;
    }

}
