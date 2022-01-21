package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.GenreDTO;
import com.example.FilmLibrary.entity.Genre;
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

    public GenreDTO saveGenre(GenreDTO genreDTO) {
        return GenreMapper.GENRE_MAPPER.fromGenre(genreRepository.save(GenreMapper.GENRE_MAPPER.toGenre(genreDTO)));
    }

    public List<GenreDTO> getAllGenre() {
        List<GenreDTO> genreDTOList = new ArrayList<>();
        List <Genre> genreList=genreRepository.findAll();
        for ( Genre genre: genreList){
            genreDTOList.add(GenreMapper.GENRE_MAPPER.fromGenre(genre));
        }
        return genreDTOList;
    }

    public GenreDTO getGenreById(Long id) {
        return GenreMapper.GENRE_MAPPER.fromGenre(genreRepository.findById(id).orElse(null));
    }

    public GenreDTO updateGenre (GenreDTO genreDTO) {
        Genre existingGenre = genreRepository.findById(GenreMapper.GENRE_MAPPER.toGenre(genreDTO).getId()).orElse(null);
        existingGenre.setCategory (GenreMapper.GENRE_MAPPER.toGenre(genreDTO).getCategory());
        return GenreMapper.GENRE_MAPPER.fromGenre(genreRepository.save(existingGenre));
    }

    public List<GenreDTO> getAllGenreWithFilm() {
       List<GenreDTO> genreDTOList=new ArrayList<>();
        List<Genre> genreList = (genreRepository.findAll());
        for (Genre genre : genreList) {
            genreDTOList.add(GenreMapper.GENRE_MAPPER.fromGenre(genre));
        }
        return genreDTOList;
    }

}
