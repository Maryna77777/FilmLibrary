package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.DTO.CountryDTO;
import com.example.FilmLibrary.service.CountryService;
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

    @PostMapping()
    public CountryDTO addCountry(@Valid @RequestBody CountryDTO countryDTO){return service.saveCountry(countryDTO);}

    @GetMapping("/all")
    public List<CountryDTO> findAllCountry() {
        return service.getAllCountry();
    }

    @GetMapping("/byId/{id}")
    public CountryDTO findCountryById(@PathVariable Long id) {
        return service.getCountryById(id);
    }

    @PutMapping("/update")
    public CountryDTO updateCountry(@RequestBody CountryDTO countryDTO) {
        return service.updateCountry(countryDTO);
    }

}
