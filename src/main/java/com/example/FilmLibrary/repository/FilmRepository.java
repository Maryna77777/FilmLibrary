package com.example.FilmLibrary.repository;

import com.example.FilmLibrary.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository

public interface FilmRepository extends JpaRepository <Film,Long>, JpaSpecificationExecutor<Film> {

    Page<Film> findAll(Specification<Film> spec, Pageable pageable);


    Page<Film> findAll(Pageable pageable);

    Film findByTitle(String title);

    @Query("select f from Film f where f.title like %:title%")
    List<Film> findByLikeTitle(@Param("title") String title);


    @Query("select  f from Film f join f.genres g where g.category = :category")
    List<Film> findByCategory(@Param("category") String category);

    @Query("select  f from Film f join f.genres g where g.category = :category")
    Page<Film> findByCategory(@Param("category") String category,Pageable pageable);

    @Query("select count(f) from Film f join f.genres g where g.category = :category")
    long countFilmByCategory(@Param("category") String category);


    @Query("select f from Film f join f.filmDirectors d where d.lastName = :lastName")
    List<Film> findByLastNameDirector(@Param("lastName") String lastName, Sort sort);

    List<Film> findByYear(int year);

    @Query("select  f from Film f join f.actors a where  a.lastName = :lastName")
    List<Film> findByLastName(@Param("lastName") String lastName);

    long countFilmByYear(int year);

    @Query("select count(f) from Film f join f.genres g where g.id = :id")
    long countFilmByCategoryById(@Param("id") Long id);
}





