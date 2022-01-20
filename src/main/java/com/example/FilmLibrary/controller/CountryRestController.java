package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.entity.Country;
import com.example.FilmLibrary.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/country")
public class CountryRestController {
    @Autowired
    private CountryService service;

    @PostMapping()
    public Country addCountry(@Valid @RequestBody Country country){return service.saveCountry(country);}

}
