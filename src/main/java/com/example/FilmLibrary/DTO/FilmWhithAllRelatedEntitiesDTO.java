package com.example.FilmLibrary.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmWhithAllRelatedEntitiesDTO extends FilmDTO{
    private CountryDTO country;
    private List <GenreDTO> genres;
    private List<ActorDTO> actors;
    private List <DirectorDTO> filmDirectors;
}


