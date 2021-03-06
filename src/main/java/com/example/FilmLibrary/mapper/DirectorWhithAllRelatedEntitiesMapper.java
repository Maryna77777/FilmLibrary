package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.DirectorDTO;
import com.example.FilmLibrary.DTO.DirectorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorWhithAllRelatedEntitiesMapper {
    DirectorWhithAllRelatedEntitiesMapper DIRECTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER = Mappers.getMapper(DirectorWhithAllRelatedEntitiesMapper.class);
    DirectorWhithAllRelatedEntitiesDTO fromDirector(Director director);
    Director toDirector(DirectorWhithAllRelatedEntitiesDTO directorWhithAllRelatedEntitiesDTO);
    List<DirectorWhithAllRelatedEntitiesDTO> fromListCountry(List<Director> directorList);
}
