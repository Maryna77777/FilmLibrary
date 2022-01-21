package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Actor;
import com.example.FilmLibrary.mapper.ActorMapper;
import com.example.FilmLibrary.mapper.ActorWhithAllRelatedEntitiesMapper;
import com.example.FilmLibrary.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> saveActors(List<Actor> actors) {
        return actorRepository.saveAll(actors);
    }

    public List<ActorDTO> getAllActors() {
        List<ActorDTO> actorDTOList = new ArrayList<>();
        List <Actor> actorList=actorRepository.findAll();
        for ( Actor actor: actorList){
            actorDTOList.add(ActorMapper.ACTOR_MAPPER.fromActor(actor));
        }
        System.out.println(actorRepository.findAll().size());
        return actorDTOList;
    }

    public ActorWhithAllRelatedEntitiesDTO getActorById(Long id) {
        return ActorWhithAllRelatedEntitiesMapper.ACTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromActor(actorRepository.findById(id).orElse(null));
    }

    public ActorWhithAllRelatedEntitiesDTO getActorByLastName(String lastName) {
        return ActorWhithAllRelatedEntitiesMapper.ACTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromActor(actorRepository.findByLastName(lastName));
    }

    public List<ActorWhithAllRelatedEntitiesDTO> findActorFilms (String title){
        List<ActorWhithAllRelatedEntitiesDTO> actorDTOList = new ArrayList<>();
        List <Actor> actorList=actorRepository.findActorByFilm(title);
        for ( Actor actor: actorList){
            actorDTOList.add(ActorWhithAllRelatedEntitiesMapper.ACTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromActor(actor));
        }
        return actorDTOList;
    }

    public Actor updateActor (Actor actor) {
        Actor existingActor = actorRepository.findById(actor.getId()).orElse(null);
        existingActor.setFirstName (actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        return actorRepository.save(existingActor);
    }

    public String deleteActor(Long id) {
        actorRepository.deleteById(id);
        return "actor removed !! " + id;
    }
}
