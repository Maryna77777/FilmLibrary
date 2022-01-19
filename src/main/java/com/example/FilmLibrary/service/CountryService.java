package com.example.FilmLibrary.service;


import com.example.FilmLibrary.entity.Country;
import com.example.FilmLibrary.entity.Film;
import com.example.FilmLibrary.repository.CountryRepository;
import com.example.FilmLibrary.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private FilmRepository filmRepository;

    public List<Country> saveCountry() {

        List<Country> countryList = countryRepository.findAll();
        List<Film> filmList = filmRepository.findAll();

        for(int j = 0; j <filmList.size(); j++){
 //       for (Film f : filmList) {
            for(int i = 0; i<countryList.size(); i++){
//            for (Country c : countryList) {
                if (filmList.get(j).getCountryName().equals(countryList.get(i).getName())){
//                    filmList.get(j).setTitle(filmList.get(j).getTitle());
//                    filmList.get(j).setYear(filmList.get(j).getYear());
                    filmList.get(j).setCountry(countryList.get(i));
                }

                else {
                    Country country = new Country();
                    country.setId(country.getId());
                    country.setName(filmList.get(j).getCountryName());
                    countryList.add(country);
//                    filmList.get(j).setTitle(filmList.get(j).getTitle());
//                    filmList.get(j).setYear(filmList.get(j).getYear());
                    filmList.get(j).setCountry(country);
                }
            }
        }
 //       return countryList;
        List<Film> savedFilms = filmRepository.saveAll(filmList);
        List<Country> savedCountries = countryRepository.saveAll(countryList);
        return savedCountries;
   }
}
