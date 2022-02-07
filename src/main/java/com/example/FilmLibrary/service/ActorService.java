package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActorService {
    List<ActorDTO> getAllActors();
    ActorDTO saveActor(ActorDTO actorDTO);
    Page<ActorDTO> getAllActorPage(Pageable pageable);
    ActorWhithAllRelatedEntitiesDTO getActorById(Long id);
    ActorWhithAllRelatedEntitiesDTO getActorByLastName(String lastName);
    List<ActorWhithAllRelatedEntitiesDTO> findActorFilms (String title);
    ActorDTO updateActor (ActorDTO actorDTO);
    String deleteActor(Long id);
}
