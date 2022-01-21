package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActorWhithAllRelatedEntitiesMapper {
    ActorWhithAllRelatedEntitiesMapper ACTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER= Mappers.getMapper(ActorWhithAllRelatedEntitiesMapper.class);
    ActorWhithAllRelatedEntitiesDTO fromActor(Actor actor);
    Actor toActor(ActorWhithAllRelatedEntitiesDTO actorWhithAllRelatedEntitiesDTO);
}


