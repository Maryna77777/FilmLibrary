package com.example.FilmLibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="actor")
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotBlank
    @Column(name = "LAST_NAME")
    private String lastName;
    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;
    @ManyToOne (fetch = FetchType.LAZY, cascade=CascadeType.ALL )
//   @JoinColumn(name = "country_id")
    private Country country;
}
