package com.example.FilmLibrary.service;

import com.example.FilmLibrary.DTO.DirectorDTO;
import com.example.FilmLibrary.DTO.DirectorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Director;
import com.example.FilmLibrary.mapper.DirectorMapper;
import com.example.FilmLibrary.mapper.DirectorWhithAllRelatedEntitiesMapper;
import com.example.FilmLibrary.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public DirectorDTO saveDirector(DirectorDTO directorDTO) {
        return   DirectorMapper.DIRECTOR_MAPPER.fromDirector(directorRepository.save(DirectorMapper.DIRECTOR_MAPPER.toDirector(directorDTO)));
    }

    public DirectorWhithAllRelatedEntitiesDTO getDirectorById(Long id) {
        return DirectorWhithAllRelatedEntitiesMapper.DIRECTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromDirector(directorRepository.findById(id).orElse(null));
    }

    public DirectorWhithAllRelatedEntitiesDTO getDirectorByLastName(String lastName) {
        return DirectorWhithAllRelatedEntitiesMapper.DIRECTOR_WHITH_ALL_RELATED_ENTITIES_MAPPER.fromDirector(directorRepository.findByLastName(lastName));
    }

    public DirectorDTO updateDirector (DirectorDTO directorDTO) {
        Director existingDirector = directorRepository.findById(DirectorMapper.DIRECTOR_MAPPER.toDirector(directorDTO).getId()).orElse(null);
        existingDirector.setFirstName (DirectorMapper.DIRECTOR_MAPPER.toDirector(directorDTO).getFirstName());
        existingDirector.setLastName(DirectorMapper.DIRECTOR_MAPPER.toDirector(directorDTO).getLastName());
        return DirectorMapper.DIRECTOR_MAPPER.fromDirector(directorRepository.save(existingDirector));
    }

    public String deleteDirector(Long id) {
        directorRepository.deleteById(id);
        return "Director removed !! " + id;
    }

    public List<DirectorDTO> getAllDirector() {
        List<DirectorDTO> directorDTOList = new ArrayList<>();
        List<Director> directorList = directorRepository.findAll(Sort.by("lastNameDirector"));
        for (Director director: directorList) {
            directorDTOList.add(DirectorMapper.DIRECTOR_MAPPER.fromDirector(director));
        }
        return directorDTOList;
    }

    public Page<Director> getDirectorPage(Pageable pageable) {
        return directorRepository.findAll(pageable) ;
    }

}