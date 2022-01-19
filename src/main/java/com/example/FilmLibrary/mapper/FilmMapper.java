package com.example.FilmLibrary.mapper;


import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper/*(uses = ActorMapper.class)*/

public interface FilmMapper {

    FilmMapper FILM_MAPPER = Mappers.getMapper(FilmMapper.class);

//    @Mapping(source = "actors", target = "actorsList")
//    @Mappings({
//            @Mapping(source = "actors", target = "actorsList"),
//            @Mapping(source = "genres", target = "genresList"),
//            @Mapping(source = "filmDirectors", target = "filmDirectorsList"),
//
//    })
    FilmDTO fromFilm(Film film);
}
