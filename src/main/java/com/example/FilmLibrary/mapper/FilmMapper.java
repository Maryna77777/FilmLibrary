package com.example.FilmLibrary.mapper;


import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper/*(uses = ActorMapper.class)*/

public interface FilmMapper {

    FilmMapper FILM_MAPPER = Mappers.getMapper(FilmMapper.class);
    FilmDTO fromFilm(Film film);
}
