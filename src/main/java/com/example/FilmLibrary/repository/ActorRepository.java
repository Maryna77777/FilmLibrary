package com.example.FilmLibrary.repository;

import com.example.FilmLibrary.entity.Actor;

import com.example.FilmLibrary.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
    Actor findByLastName(String lastName);

    @Query("select a from Actor a join a.films f where f.title = :title")
    List<Actor> findActorByFilm(@Param("title") String title);
}

