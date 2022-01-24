package com.example.FilmLibrary.repository;

import com.example.FilmLibrary.entity.Director;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
    Director findByLastName(String lastNameDirector);
    Page<Director> findAll(Pageable pageable);
  //  Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
