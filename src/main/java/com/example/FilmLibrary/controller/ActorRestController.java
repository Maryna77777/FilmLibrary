package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Actor;
import com.example.FilmLibrary.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorRestController {
    @Autowired
    ActorService actorService;

    @PostMapping("/addActor")
    public Actor addActor (@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }

    @GetMapping("/findActorFilm/{title}")
    public List<ActorWhithAllRelatedEntitiesDTO> findActorFilm (@PathVariable String title){
        return actorService.findActorFilms(title);
    }

    @PostMapping("/addActors")
    public List<Actor> addActors(@RequestBody List<Actor> actorList) {
        return actorService.saveActors(actorList);
    }

    @GetMapping("/allActors")
    public List<ActorDTO> findAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/actorById/{id}")
    public ActorWhithAllRelatedEntitiesDTO findActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @GetMapping("/actorByName/{lastName}")
    public ActorWhithAllRelatedEntitiesDTO findActorByLastName(@PathVariable String lastName) {
        return actorService.getActorByLastName(lastName);
    }

    @PutMapping("/updateActor")
    public Actor updateActor(@RequestBody Actor actor) {
        return actorService.updateActor(actor);
    }

    @DeleteMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable Long id) {
        return actorService.deleteActor(id);
    }

}