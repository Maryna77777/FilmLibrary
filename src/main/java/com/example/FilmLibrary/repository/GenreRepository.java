package com.example.FilmLibrary.repository;

import com.example.FilmLibrary.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByCategory(String category);
}

