package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.GenreWithFilmDTO;
import com.example.FilmLibrary.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GenreWithFilmMapper {
    GenreWithFilmMapper GENRE_WITH_FILM_MAPPER = Mappers.getMapper(GenreWithFilmMapper.class);
    GenreWithFilmDTO fromGenre(Genre genre);
}
