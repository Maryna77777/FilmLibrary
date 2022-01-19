package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.entity.Country;
import com.example.FilmLibrary.service.CountryService;
import com.example.FilmLibrary.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/country")
public class CountryRestController {
    @Autowired
    private CountryService service;

    @PutMapping("/add")
    public List<Country> newCountry () {return service.saveCountry();}


}
