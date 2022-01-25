package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.DTO.DirectorDTO;
import com.example.FilmLibrary.DTO.DirectorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorRestController {
    @Autowired
    DirectorService directorService;

    @PostMapping("/add")
    public DirectorDTO addDirector  (@RequestBody DirectorDTO directorDTO ) {
        return directorService.saveDirector (directorDTO);
    }

    @GetMapping("/all")
   public List<DirectorDTO> findAllDirectors() {
     return directorService.getAllDirector();
 }

    @GetMapping("/allPage")
    public Page<DirectorDTO> findAllDirectorsPage(@PageableDefault(sort = "lastName", size = 25, direction = Sort.Direction.ASC) Pageable pageable){
        return directorService.getAllDirectorsPage(pageable);
    }

    @GetMapping("/byId/{id}")
    public DirectorWhithAllRelatedEntitiesDTO findDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id);
    }

    @GetMapping("/byName/{lastName}")
    public DirectorWhithAllRelatedEntitiesDTO findDirectorByLastName(@PathVariable String lastName) {
        return directorService.getDirectorByLastName(lastName);
    }

    @PutMapping("/update")
    public DirectorDTO updateDirector(@RequestBody DirectorDTO directorDTO) {
        return directorService.updateDirector(directorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDirector(@PathVariable Long id) {
        return directorService.deleteDirector(id);
    }

}


