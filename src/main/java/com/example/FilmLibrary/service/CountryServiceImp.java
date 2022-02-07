package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.CountryDTO;
import com.example.FilmLibrary.entity.Country;
import com.example.FilmLibrary.mapper.CountryMapper;
import com.example.FilmLibrary.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CountryServiceImp implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryDTO saveCountry(CountryDTO countryDTO) {
        return CountryMapper.Country_MAPPER.fromCountry(countryRepository.save(CountryMapper.Country_MAPPER.toCountry(countryDTO)));
    }

    public List<CountryDTO> getAllCountry() {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        List <Country> countryList=countryRepository.findAll();
        for ( Country country: countryList){
            countryDTOList.add(CountryMapper.Country_MAPPER.fromCountry(country));
        }
        return countryDTOList;
    }

    public CountryDTO getCountryById(Long id) {
        return CountryMapper.Country_MAPPER.fromCountry(countryRepository.findById(id).orElse(null));
    }

    public CountryDTO updateCountry (CountryDTO countryDTO) {
        Country existingCountry = countryRepository.findById(CountryMapper.Country_MAPPER.toCountry(countryDTO).getId()).orElse(null);
        existingCountry.setId(CountryMapper.Country_MAPPER.toCountry(countryDTO).getId());
        existingCountry.setName(CountryMapper.Country_MAPPER.toCountry(countryDTO).getName());

        return CountryMapper.Country_MAPPER.fromCountry(countryRepository.save(existingCountry));
    }

}
