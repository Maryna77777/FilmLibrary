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

    @PostMapping("/add")
    public GenreDTO addGenre (@RequestBody GenreDTO genreDTO) {
        return genreService.saveGenre(genreDTO);
    }

    @GetMapping("/list")
    public List<GenreDTO> findAllGenres() {
        return genreService.getAllGenre();
    }

    @GetMapping("/byId/{id}")
    public GenreDTO findGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

    @PutMapping("/update")
    public GenreDTO updateGenre(@RequestBody GenreDTO genreDTO) {
        return genreService.updateGenre(genreDTO);
    }

}
