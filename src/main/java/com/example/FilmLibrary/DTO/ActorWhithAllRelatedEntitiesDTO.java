package com.example.FilmLibrary.DTO;


import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class ActorWhithAllRelatedEntitiesDTO extends ActorDTO {
    private List<FilmDTO> films;
    private CountryDTO country;
}
