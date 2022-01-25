package com.example.FilmLibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="director")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FIRST_NAME_DIRECTOR")
    private String firstName;
    @Column(name = "LAST_NAME_DIRECTOR")
    private String lastName;
    @JsonIgnore
    @ManyToMany(mappedBy = "filmDirectors")
    private List<Film> films;
    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY, cascade=CascadeType.ALL )
    private Country country;
}
