package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorWhithAllRelatedEntitiesMapper {
    ActorWhithAllRelatedEntitiesMapper ACTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER= Mappers.getMapper(ActorWhithAllRelatedEntitiesMapper.class);
    ActorWhithAllRelatedEntitiesDTO fromActor(Actor actor);
    Actor toActor(ActorWhithAllRelatedEntitiesDTO actorWhithAllRelatedEntitiesDTO);
    List<ActorWhithAllRelatedEntitiesDTO> fromListActors(List<Actor> actorList);
}


