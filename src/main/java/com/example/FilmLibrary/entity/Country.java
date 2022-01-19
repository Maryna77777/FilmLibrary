package com.example.FilmLibrary.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<Film> films;

//    @JsonIgnore
//    @OneToMany(mappedBy="country",cascade=CascadeType.ALL )
//    private List<Film> films;
}
