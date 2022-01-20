package com.example.FilmLibrary.controller;

import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.DTO.FilmWhithActorDTO;
import com.example.FilmLibrary.entity.Film;
import com.example.FilmLibrary.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
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
    public Film addFilm(@Valid @RequestBody Film film) {
        return service.saveFilm(film);
    }

    @PostMapping("/addFilms")
    public List<Film> addFilms(@RequestBody @Valid List<Film> filmList) {
        return service.saveFilms(filmList);
    }

    @GetMapping("/allFilms")
    public List<Film> findAllFilms() {
        return service.getFilm();
    }

    @GetMapping("/allFilmsWhithActors")
    public List<FilmDTO> findAllFilmsWithActors() {
        return service.getAllFilmsWithActors();
    }

    @GetMapping("/allFilmsPage")
    public Page<Film> findAllFilmPage(@PageableDefault(sort = "title", direction = Sort.Direction.ASC, size = 50) Pageable pageable) {
        return service.getFilmPage(pageable);
    }

    @GetMapping("/filmById/{id}")
    public Film findFilmById(@PathVariable Long id) {
        return service.getFilmById(id);
    }

    @GetMapping("/findByLikeTitle/{title}")
    public List<Film> findByLikeTitle(@PathVariable String title) {
        return service.getByLikeTitle(title);
    }

    @GetMapping("/filmByTitle/{title}")
    public Film findFilmByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @PutMapping("/updateFilm")
    @RequestMapping(value = "/updateFilm", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Film updateFilm(@Valid @RequestBody Film film, BindingResult bindingResul) {
        return service.updateFilm(film);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        return service.deleteFilm(id);
    }

    @GetMapping("/filmByYear/{year}")
    public List<Film> findFilmByYear(@PathVariable int year) {
        return service.findByYear(year);
    }

    @GetMapping("/findFilmGenre/{category}")
    public List<Film> findFilmGenre(@PathVariable String category) {
        return service.getFilmGenre(category);
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
    public List<Film> findFilmActor(@PathVariable String lastName) {
        return service.getFilmActor(lastName);
    }

    @GetMapping("/findFilmDirector/{lastNameDirector}")
    public List<Film> findFilmDirector(@PathVariable String lastNameDirector) {
        return service.getFilmDirector(lastNameDirector);
    }
}

