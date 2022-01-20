package com.example.FilmLibrary.service;


import com.example.FilmLibrary.entity.Actor;
import com.example.FilmLibrary.entity.Country;
import com.example.FilmLibrary.entity.Director;
import com.example.FilmLibrary.entity.Film;
import com.example.FilmLibrary.repository.ActorRepository;
import com.example.FilmLibrary.repository.CountryRepository;
import com.example.FilmLibrary.repository.DirectorRepository;
import com.example.FilmLibrary.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}
