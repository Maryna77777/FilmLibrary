package com.example.FilmLibrary.repository;


import com.example.FilmLibrary.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository  extends JpaRepository<Country,Long> {
}
