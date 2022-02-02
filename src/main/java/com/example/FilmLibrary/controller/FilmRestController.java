package com.example.FilmLibrary.controller;

import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.DTO.FilmWhithAllRelatedEntitiesDTO;
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

    @GetMapping("/all")
    public List<FilmDTO> findAllFilms() {
        return service.getAllFilms();
    }

    @GetMapping("/allWhithActors")
    public List<FilmWhithAllRelatedEntitiesDTO> findAllFilmsWithAllRelatedEntities() {
        return service.getAllFilmsWhithAllRelatedEntities();
    }

    @GetMapping("/allPage")
    public Page<FilmDTO> findAllFilmPage(@PageableDefault(sort = "title", size = 25, direction = Sort.Direction.ASC) Pageable pageable){
        return service.getAllFilmsPage(pageable);
    }

    @GetMapping("/byId/{id}")
    public FilmWhithAllRelatedEntitiesDTO findFilmById(@PathVariable Long id) {
        return service.getFilmById(id);
    }

    @GetMapping("/byLikeTitle/{title}")
    public List<FilmWhithAllRelatedEntitiesDTO> findByLikeTitle(@PathVariable String title) {
        return service.getByLikeTitle(title);
    }

    @GetMapping("/byTitle/{title}")
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

    @GetMapping("/byYear/{year}")
    public List<FilmWhithAllRelatedEntitiesDTO> findFilmByYear(@PathVariable int year) {
        return service.findByYear(year);
    }

    @GetMapping("/byGenre/{category}")
    public Page<FilmWhithAllRelatedEntitiesDTO> findFilmGenre(@PathVariable String category,
                                                              @PageableDefault(sort = "title", size = 25, direction = Sort.Direction.ASC) Pageable pageable){
        return service.getFilmGenre(category, pageable);
    }

    @GetMapping("/count/byGenre/{category}")
    public long countFilmGenre(@PathVariable String category) {
        return service.countCategory(category);
    }

    @GetMapping("/count/FilmYear/{year}")
    public long countFilmYear(@PathVariable int year) {
        return service.countYear(year);
    }

    @GetMapping("/byActor/{lastName}")
    public List<FilmDTO> findFilmActor(@PathVariable String lastName) {
        return service.getFilmActor(lastName);
    }

    @GetMapping("/byDirector/{lastName}")
    public List<FilmDTO> findFilmDirector(@PathVariable String lastName) {
        return service.getFilmDirector(lastName);
    }


    @GetMapping("country/{country}")
    public List<FilmDTO> findSpecificationByCountry (String country){
        return service.findSpecificationByCountry(country);
    }

    @GetMapping("title/{title}/year/{year}/country/{country}/genre/{genre}")
    public List<FilmDTO> findFilmFiltration (@PathVariable(required = false) String title,
                                             @PathVariable(required = false) int year,
                                             @PathVariable(required = false) String country,
                                             @PathVariable(required = false) String genre){
        return service.getFilmsFiltration(title,year, country, genre);
    }

    @GetMapping("filtration")
    public List<FilmDTO> findFilmFiltration1 (@RequestParam (required = false) String title,
                                              @RequestParam (required = false) int year,
                                              @RequestParam (required = false) String country,
                                              @RequestParam (required = false) String genre){
        return service.getFilmsFiltration1(title,year, country, genre);
    }
}

