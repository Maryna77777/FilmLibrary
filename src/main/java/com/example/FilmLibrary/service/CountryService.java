package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO saveCountry(CountryDTO countryDTO);
    List<CountryDTO> getAllCountry();
    CountryDTO getCountryById(Long id);
    CountryDTO updateCountry (CountryDTO countryDTO);
}
