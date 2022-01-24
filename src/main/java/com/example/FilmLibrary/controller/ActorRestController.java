package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.ActorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorRestController {
    @Autowired
    ActorService actorService;

    @PostMapping("/addActor")
    public ActorDTO addActor (@RequestBody ActorDTO actorDTO) {
        return actorService.saveActor(actorDTO);
    }

    @GetMapping("/findActorFilm/{title}")
    public List<ActorWhithAllRelatedEntitiesDTO> findActorFilm (@PathVariable String title){
        return actorService.findActorFilms(title);
    }

    @GetMapping("/allActors")
    public List<ActorDTO> findAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/allActorsPage")
    public Page<ActorDTO> findAllActorsPage(@PageableDefault(sort = "lastName", direction = Sort.Direction.ASC) Pageable pageable) {
        return actorService.getAllActorPage(pageable);
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
    public ActorDTO updateActor(@RequestBody ActorDTO actorDTO) {
        return actorService.updateActor(actorDTO);
    }

    @DeleteMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable Long id) {
        return actorService.deleteActor(id);
    }

}