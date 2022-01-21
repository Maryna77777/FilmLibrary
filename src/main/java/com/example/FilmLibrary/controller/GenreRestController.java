package com.example.FilmLibrary.controller;

import com.example.FilmLibrary.DTO.GenreDTO;
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
    public GenreDTO addGenre (@RequestBody GenreDTO genreDTO) {
        return genreService.saveGenre(genreDTO);
    }

    @GetMapping("/allGenres")
    public List<GenreDTO> findAllGenres() {
        return genreService.getAllGenre();
    }

    @GetMapping("/genreById/{id}")
    public GenreDTO findGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

    @PutMapping("/updateGenre")
    public GenreDTO updateGenre(@RequestBody GenreDTO genreDTO) {
        return genreService.updateGenre(genreDTO);
    }

}
