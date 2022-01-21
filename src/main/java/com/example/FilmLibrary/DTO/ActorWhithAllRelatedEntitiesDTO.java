package com.example.FilmLibrary.DTO;


import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class ActorWhithAllRelatedEntitiesDTO {
    private long id;
    private String firstName;
    private String lastName;
    private List<FilmDTO> films;
    private CountryDTO country;
}
