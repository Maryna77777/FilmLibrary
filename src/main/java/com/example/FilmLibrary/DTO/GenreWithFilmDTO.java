package com.example.FilmLibrary.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreWithFilmDTO extends GenreDTO{
    private List<FilmDTO> films;
}
