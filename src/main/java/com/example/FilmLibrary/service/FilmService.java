package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.FilmDTO;
import com.example.FilmLibrary.DTO.FilmWhithAllRelatedEntitiesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {
    FilmDTO saveFilm(FilmDTO filmDTO);
    List<FilmDTO> getAllFilms();
    Page<FilmDTO> getAllFilmsPage(Pageable pageable);
    Page<FilmWhithAllRelatedEntitiesDTO> getFilmGenre(String category, Pageable pageable);
    FilmWhithAllRelatedEntitiesDTO  getFilmById(Long id);
    FilmWhithAllRelatedEntitiesDTO getByTitle(String title);
    List<FilmWhithAllRelatedEntitiesDTO> findByYear(int year);
    List<FilmDTO> getFilmActor(String lastName);
    List<FilmWhithAllRelatedEntitiesDTO> getByLikeTitle(String title);
    List<FilmDTO> getFilmDirector(String lastName);
    String deleteFilm(Long id);
    FilmDTO updateFilm(FilmDTO filmDTO);
    long countCategory(String category);
    long countYear( int year);
    List<FilmWhithAllRelatedEntitiesDTO> getAllFilmsWhithAllRelatedEntities();
    List<FilmDTO> getSpecificationByCountry (String country);
    Page<FilmDTO> getSpecificationByCountryPage (String country, Pageable pageable);
    Page<FilmDTO> getFilmsFiltrationPage (String title, Integer year, String country, String genre, Pageable pageable);
    Page<FilmDTO> getFilmsFiltrationPageWithoutYear (String title, String country, String genre, Pageable pageable);
}
