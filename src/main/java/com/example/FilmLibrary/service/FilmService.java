package com.example.FilmLibrary.service;


import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.DTO.FilmWhithAllRelatedEntitiesDTO;

import com.example.FilmLibrary.FilmSpecification;
import com.example.FilmLibrary.entity.Film;
import com.example.FilmLibrary.mapper.FilmMapper;

import com.example.FilmLibrary.mapper.FilmWhithAllRelatedEntitiesMapper;
import com.example.FilmLibrary.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public FilmDTO saveFilm(FilmDTO filmDTO) {
        return FilmMapper.FILM_MAPPER.fromFilm(filmRepository.save(FilmMapper.FILM_MAPPER.toFilm(filmDTO)));
    }

     public List<FilmDTO> getAllFilms() {
        return FilmMapper.FILM_MAPPER.fromListFilms(filmRepository.findAll());
    }

    public Page<FilmDTO> getAllFilmsPage(Pageable pageable) {
       Page<Film> filmPage=filmRepository.findAll(pageable);
       List<FilmDTO> filmDTOList=FilmMapper.FILM_MAPPER.fromListFilms(filmPage.getContent());
        return new PageImpl<>(filmDTOList, pageable, filmPage.getTotalElements());
    }

    public Page<FilmWhithAllRelatedEntitiesDTO> getFilmGenre(String category, Pageable pageable) {
        Page<Film> filmPage = filmRepository.findByCategory(category, pageable);
        List<FilmWhithAllRelatedEntitiesDTO> filmDTOList = FilmWhithAllRelatedEntitiesMapper.FILM_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromListFilms(filmPage.getContent());
        return new PageImpl<>(filmDTOList, pageable, filmPage.getTotalElements());
    }

    public FilmWhithAllRelatedEntitiesDTO  getFilmById(Long id) {
        return FilmWhithAllRelatedEntitiesMapper.FILM_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromFilm(filmRepository.findById(id).orElse(null));
    }

    public FilmWhithAllRelatedEntitiesDTO getByTitle(String title) {
        return FilmWhithAllRelatedEntitiesMapper.FILM_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromFilm(filmRepository.findByTitle(title));
    }

    public List<FilmWhithAllRelatedEntitiesDTO> findByYear(int year) {
        List<FilmWhithAllRelatedEntitiesDTO> filmMapperDTOList = new ArrayList<>();
        List<Film> filmList = filmRepository.findByYear(year);
        for (Film film : filmList) {
            filmMapperDTOList.add(FilmWhithAllRelatedEntitiesMapper.FILM_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromFilm(film));
        }
        return filmMapperDTOList;
    }

    public List<FilmDTO> getFilmActor(String lastName) {
        List<FilmDTO> filmMapperDTOList = new ArrayList<>();
        List<Film> filmList = filmRepository.findByLastName(lastName);
        for (Film film : filmList) {
            filmMapperDTOList.add(FilmMapper.FILM_MAPPER.fromFilm(film));
        }
        return filmMapperDTOList;

    }

    public List<FilmWhithAllRelatedEntitiesDTO> getByLikeTitle(String title) {
        List<FilmWhithAllRelatedEntitiesDTO> filmMapperDTOList = new ArrayList<>();
        List<Film> filmList = filmRepository.findByLikeTitle(title);
        for (Film film : filmList) {
            filmMapperDTOList.add(FilmWhithAllRelatedEntitiesMapper.FILM_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromFilm(film));
        }
        return filmMapperDTOList;
    }

    public List<FilmDTO> getFilmDirector(String lastName) {
        List<FilmDTO> filmMapperDTOList = new ArrayList<>();
        List<Film> filmList = filmRepository.findByLastNameDirector(lastName, Sort.by("year"));
        for (Film film : filmList) {
            filmMapperDTOList.add(FilmMapper.FILM_MAPPER.fromFilm(film));
        }
        return filmMapperDTOList;
    }

    public String deleteFilm(Long id) {
        filmRepository.deleteById(id);
        return "film removed !! " + id;
    }

    public FilmDTO updateFilm(FilmDTO filmDTO) {
        Film existingFilm = filmRepository.findById(FilmMapper.FILM_MAPPER.toFilm(filmDTO).getId()).orElse(null);
        existingFilm.setTitle(FilmMapper.FILM_MAPPER.toFilm(filmDTO).getTitle());
        existingFilm.setYear(FilmMapper.FILM_MAPPER.toFilm(filmDTO).getYear());
        return FilmMapper.FILM_MAPPER.fromFilm(filmRepository.save(existingFilm));
    }

    public long countCategory(String category) {
        return filmRepository.countFilmByCategory(category);
    }

    public long countYear( int year){
        return filmRepository.countFilmByYear(year);
    }

    public List<FilmWhithAllRelatedEntitiesDTO> getAllFilmsWhithAllRelatedEntities() {
        List<FilmWhithAllRelatedEntitiesDTO> filmMapperDTOList = new ArrayList<>();
        List<Film> filmList = filmRepository.findAll(Sort.by("title"));
        for (Film film : filmList) {
            filmMapperDTOList.add(FilmWhithAllRelatedEntitiesMapper.FILM_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromFilm(film));
        }
        return filmMapperDTOList;
    }

    public List<FilmDTO> findSpecificationByCountry (String country){
         return FilmMapper.FILM_MAPPER.fromListFilms(filmRepository.findAll(FilmSpecification.getFilmsSpecificationJoinCountry(country)));
    }

    public List<FilmDTO> getFilmsFiltration (String title, int year, String country, String genre){
        return FilmMapper.FILM_MAPPER.fromListFilms(filmRepository.findAll(FilmSpecification.getFilmsAllSpecification(title, year, country, genre)));
    }

    public List<FilmDTO> getFilmsFiltration1 (String title, int year, String country, String genre){
        return FilmMapper.FILM_MAPPER.fromListFilms(filmRepository.findAll(FilmSpecification.getFilmsAllSpecification1(title, year, country, genre)));
    }

}

