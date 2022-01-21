package com.example.FilmLibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="film")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=2, max=50, message = "Title should be between 2 and 50 character")
    @NotEmpty(message = "Title should not be empty")
    @Column(name = "title")
    private String title;

    @Min(value = 1888, message = "Year should be greater 1888")
    @Max(value = 2121)
    @Column(name = "year")
    private int year;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID")
    )
    private List<Actor> actors;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID")
    )
    private List <Genre> genres;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_director",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "DIRECTOR_ID")
    )
    private List <Director> filmDirectors;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY, cascade=CascadeType.ALL )
    private Country country;
}
