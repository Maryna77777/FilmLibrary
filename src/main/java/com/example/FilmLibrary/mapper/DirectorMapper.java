package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.DirectorDTO;
import com.example.FilmLibrary.entity.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper DIRECTOR_MAPPER = Mappers.getMapper(DirectorMapper.class);
    DirectorDTO fromDirector(Director director);
    Director toDirector(DirectorDTO directorDTO);
}

