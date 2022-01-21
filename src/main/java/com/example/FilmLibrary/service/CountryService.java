package com.example.FilmLibrary.service;


import com.example.FilmLibrary.entity.Country;
import com.example.FilmLibrary.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}
