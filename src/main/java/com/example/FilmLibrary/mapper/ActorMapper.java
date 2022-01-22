package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.entity.Actor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorMapper ACTOR_MAPPER = Mappers.getMapper(ActorMapper.class);
    ActorDTO fromActor(Actor actor);
    @InheritInverseConfiguration
    Actor toActor(ActorDTO actorDTO);
    List<ActorDTO> fromListActors(List<Actor> actorList);
}
