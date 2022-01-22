package com.example.FilmLibrary.mapper;

import com.example.FilmLibrary.DTO.ActorDTO;
import com.example.FilmLibrary.DTO.CountryDTO;
import com.example.FilmLibrary.entity.Actor;
import com.example.FilmLibrary.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper Country_MAPPER = Mappers.getMapper(CountryMapper.class);
    CountryDTO fromCountry(Country country);
    Country toCountry(CountryDTO countryDTO);
    List<CountryDTO> fromListCountry(List<Country> countryList);
}

