package com.example.FilmLibrary.mapper;



import com.example.FilmLibrary.DTO.FilmWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FilmWhithAllRelatedEntitiesMapper {
    FilmWhithAllRelatedEntitiesMapper FILM_WHITH_ALL_RELATED_ENTITIES_MAPPER = Mappers.getMapper(FilmWhithAllRelatedEntitiesMapper.class);
    FilmWhithAllRelatedEntitiesDTO fromFilm(Film film);
}
