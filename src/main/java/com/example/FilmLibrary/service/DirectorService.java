package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.DirectorDTO;
import com.example.FilmLibrary.DTO.DirectorWhithAllRelatedEntitiesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DirectorService {
    DirectorDTO saveDirector(DirectorDTO directorDTO);
    DirectorWhithAllRelatedEntitiesDTO getDirectorById(Long id);
    DirectorWhithAllRelatedEntitiesDTO getDirectorByLastName(String lastName);
    DirectorDTO updateDirector (DirectorDTO directorDTO);
    String deleteDirector(Long id);
    List<DirectorDTO> getAllDirector();
    Page<DirectorDTO> getAllDirectorsPage(Pageable pageable);

}
