package com.example.FilmLibrary.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmDTO {
    private long id;
    private String title;
    private int year;
    private String countryName;
    private List<ActorDTO> actors;


}
