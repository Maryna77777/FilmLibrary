package com.example.FilmLibrary.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreWithFilmDTO {
    private long id;
    private String category;
    private List<FilmDTO> films;
}
