package com.example.FilmLibrary.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DirectorWhithAllRelatedEntitiesDTO extends DirectorDTO{
    private List<FilmDTO> films;
    private CountryDTO country;
}
