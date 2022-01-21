package com.example.FilmLibrary.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DirectorWhithAllRelatedEntitiesDTO {
    private long id;
    private String firstNameDirector;
    private String lastNameDirector;
    private List<FilmDTO> films;
    private CountryDTO country;
}
