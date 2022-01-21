package com.example.FilmLibrary.controller;

import com.example.FilmLibrary.DTO.GenreDTO;
import com.example.FilmLibrary.entity.Genre;
import com.example.FilmLibrary.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreRestController {
    @Autowired
    GenreService genreService;

    @GetMapping("/allGenreFilm")
    public List<GenreDTO> findAllGenreFilm(){

        return genreService.getAllGenreWithFilm();
    }

    @PostMapping("/addGenre")
    public Genre addGenre (@RequestBody Genre genre) {
        return genreService.saveGenre (genre);
    }

    @GetMapping("/allGenres")
    public List<GenreDTO> findAllGenres() {
        return genreService.getAllGenre();
    }

    @GetMapping("/genreById/{id}")
    public Genre findGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

      @PutMapping("/updateGenre")
    public Genre updateGenre(@RequestBody Genre genre) {
        return genreService.updateGenre(genre);
    }

}
