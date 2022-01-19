package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.entity.Country;
import com.example.FilmLibrary.entity.Film;
import com.example.FilmLibrary.service.CountryService;
import com.example.FilmLibrary.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/country")
public class CountryRestController {
    @Autowired
    private CountryService service;

    @PutMapping("/add")
    public List<Country> newCountry () {return service.saveCountry();}

    @PostMapping()
    public Country addCountry(@Valid @RequestBody Country country){return service.saveCuntry1(country);}

}
