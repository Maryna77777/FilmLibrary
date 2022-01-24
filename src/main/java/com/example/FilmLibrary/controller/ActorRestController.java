package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorRestController {
    @Autowired
    ActorService actorService;

    @PostMapping("/add")
    public ActorDTO addActor (@RequestBody ActorDTO actorDTO) {
        return actorService.saveActor(actorDTO);
    }

    @GetMapping("/byFilm/{title}")
    public List<ActorWhithAllRelatedEntitiesDTO> findActorFilm (@PathVariable String title){
        return actorService.findActorFilms(title);
    }

    @GetMapping("/list")
    public List<ActorDTO> findAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/byId/{id}")
    public ActorWhithAllRelatedEntitiesDTO findActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @GetMapping("/byName/{lastName}")
    public ActorWhithAllRelatedEntitiesDTO findActorByLastName(@PathVariable String lastName) {
        return actorService.getActorByLastName(lastName);
    }

    @PutMapping("/update")
    public ActorDTO updateActor(@RequestBody ActorDTO actorDTO) {
        return actorService.updateActor(actorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteActor(@PathVariable Long id) {
        return actorService.deleteActor(id);
    }

}