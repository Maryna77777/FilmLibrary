package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.entity.Film;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    FilmMapper FILM_MAPPER = Mappers.getMapper(FilmMapper.class);
    @Mappings
              ({@Mapping(source = "id", target = "id"),
                @Mapping(source = "title", target = "title"),
                @Mapping(source = "year", target = "year")
    })
    FilmDTO fromFilm(Film film);
    @InheritInverseConfiguration
    Film toFilm(FilmDTO filmDTO);
}

