package com.example.FilmLibrary.mapper;


import com.example.FilmLibrary.DTO.GenreDTO;
import com.example.FilmLibrary.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface GenreMapper {
    GenreMapper Genre_MAPPER = Mappers.getMapper(GenreMapper.class);
    GenreDTO fromGenre(Genre genre);
}
