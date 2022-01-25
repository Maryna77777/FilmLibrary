package com.example.FilmLibrary.repository;

import com.example.FilmLibrary.entity.Director;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director,Long> {
    Director findByLastName(String lastName);
    Page<Director> findAll(Pageable pageable);
//    List<Director> findAll();

 //   List<Director> findAll(Sort sort);
}
