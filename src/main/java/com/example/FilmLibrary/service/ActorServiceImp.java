package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Actor;
import com.example.FilmLibrary.mapper.ActorMapper;
import com.example.FilmLibrary.mapper.ActorWhithAllRelatedEntitiesMapper;
import com.example.FilmLibrary.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ActorServiceImp implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public ActorDTO saveActor(ActorDTO actorDTO) {
        return ActorMapper.ACTOR_MAPPER.fromActor(actorRepository.save(ActorMapper.ACTOR_MAPPER.toActor(actorDTO)));
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

    public Page<ActorDTO> getAllActorPage(Pageable pageable) {
        Page<Actor> actorPage=actorRepository.findAll(pageable);
        List<ActorDTO> actorDTOList= ActorMapper.ACTOR_MAPPER.fromListActors(actorPage.getContent());
        return new PageImpl<>(actorDTOList, pageable, actorPage.getTotalElements());
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

    public ActorDTO updateActor (ActorDTO actorDTO) {
        Actor existingActor = actorRepository.findById(ActorMapper.ACTOR_MAPPER.toActor(actorDTO).getId()).orElse(null);
        existingActor.setFirstName (ActorMapper.ACTOR_MAPPER.toActor(actorDTO).getFirstName());
        existingActor.setLastName(ActorMapper.ACTOR_MAPPER.toActor(actorDTO).getLastName());
        return ActorMapper.ACTOR_MAPPER.fromActor(actorRepository.save(existingActor));
    }

    public String deleteActor(Long id) {
        actorRepository.deleteById(id);
        return "actor removed !! " + id;
    }
}
