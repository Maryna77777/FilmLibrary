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

    @GetMapping("/allFilms")
    public List<FilmDTO> findAllFilms() {
        return service.getAllFilms();
    }

    @GetMapping("/allFilmsWhithActors")
    public List<FilmWhithAllRelatedEntitiesDTO> findAllFilmsWithAllRelatedEntities() {
        return service.getAllFilmsWhithAllRelatedEntities();
    }

    @GetMapping("/allFilmsPage")
    public Page<FilmDTO> findAllFilmPage(@PageableDefault(sort = "title", direction = Sort.Direction.ASC, size = 50) Pageable pageable) {
        return service.getAllFilmsPage(pageable);
    }

    @GetMapping("/filmById/{id}")
    public FilmWhithAllRelatedEntitiesDTO findFilmById(@PathVariable Long id) {
        return service.getFilmById(id);
    }

    @GetMapping("/findByLikeTitle/{title}")
    public List<FilmWhithAllRelatedEntitiesDTO> findByLikeTitle(@PathVariable String title) {
        return service.getByLikeTitle(title);
    }

    @GetMapping("/filmByTitle/{title}")
    public FilmWhithAllRelatedEntitiesDTO findFilmByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @PutMapping("/updateFilm")
    public FilmDTO updateFilm(@Valid @RequestBody FilmDTO filmDTO) {
        return service.updateFilm(filmDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        return service.deleteFilm(id);
    }

    @GetMapping("/filmByYear/{year}")
    public List<FilmWhithAllRelatedEntitiesDTO> findFilmByYear(@PathVariable int year) {
        return service.findByYear(year);
    }

    @GetMapping("/findFilmGenre/{category}")
    public Page<FilmWhithAllRelatedEntitiesDTO> findFilmGenre(@PathVariable String category, @PageableDefault(sort = "title", direction = Sort.Direction.ASC, size = 50) Pageable pageable) {
        return service.getFilmGenre(category, pageable);
    }

    @GetMapping("/count/FilmGenre/{category}")
    public long countFilmGenre(@PathVariable String category) {
        return service.countCategory(category);
    }

    @GetMapping("/count/FilmYear/{year}")
    public long countFilmYear(@PathVariable int year) {
        return service.countYear(year);
    }

    @GetMapping("/findFilmActor/{lastName}")
    public List<FilmDTO> findFilmActor(@PathVariable String lastName) {
        return service.getFilmActor(lastName);
    }

    @GetMapping("/findFilmDirector/{lastNameDirector}")
    public List<FilmDTO> findFilmDirector(@PathVariable String lastNameDirector) {
        return service.getFilmDirector(lastNameDirector);
    }
}

