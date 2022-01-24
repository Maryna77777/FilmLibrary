package com.example.FilmLibrary.controller;

import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.DTO.FilmWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Film;
import com.example.FilmLibrary.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/film")
public class FilmRestController {

    @Autowired
    private FilmService service;

    @PostMapping("/")
    public FilmDTO addFilm(@Valid @RequestBody FilmDTO filmDTO) {
        return service.saveFilm(filmDTO);
    }

    @GetMapping("/list")
    public List<FilmDTO> findAllFilms() {
        return service.getAllFilms();
    }

    @GetMapping("/allFilmsWhithActors")
    public List<FilmWhithAllRelatedEntitiesDTO> findAllFilmsWithAllRelatedEntities() {
        return service.getAllFilmsWhithAllRelatedEntities();
    }

    @GetMapping("/allPage")
    public Page<Film> findAllFilmPage(@PageableDefault(sort = "title", direction = Sort.Direction.ASC, size = 50) Pageable pageable) {
        return service.getFilmPage(pageable);
    }

    @GetMapping("/byId/{id}")
    public FilmWhithAllRelatedEntitiesDTO findFilmById(@PathVariable Long id) {
        return service.getFilmById(id);
    }

    @GetMapping("/findByLikeTitle/{title}")
    public List<FilmWhithAllRelatedEntitiesDTO> findByLikeTitle(@PathVariable String title) {
        return service.getByLikeTitle(title);
    }

    @GetMapping("/findByTitle/{title}")
    public FilmWhithAllRelatedEntitiesDTO findFilmByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @PutMapping("/update")
    public FilmDTO updateFilm(@Valid @RequestBody FilmDTO filmDTO) {
        return service.updateFilm(filmDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        return service.deleteFilm(id);
    }

    @GetMapping("/byYear/{year}")
    public List<FilmWhithAllRelatedEntitiesDTO> findFilmByYear(@PathVariable int year) {
        return service.findByYear(year);
    }

    @GetMapping("/findByGenre/{category}")
    public List<FilmWhithAllRelatedEntitiesDTO> findFilmGenre(@PathVariable String category) {
        return service.getFilmGenre(category);
    }

    @GetMapping("/count/byGenre/{category}")
    public long countFilmGenre(@PathVariable String category) {
        return service.countCategory(category);
    }

    @GetMapping("/count/byYear/{year}")
    public long countFilmYear(@PathVariable int year) {
        return service.countYear(year);
    }

    @GetMapping("/findByActor/{lastName}")
    public List<FilmDTO> findFilmActor(@PathVariable String lastName) {
        return service.getFilmActor(lastName);
    }

    @GetMapping("/findByDirector/{lastNameDirector}")
    public List<FilmDTO> findFilmDirector(@PathVariable String lastNameDirector) {
        return service.getFilmDirector(lastNameDirector);
    }
}

