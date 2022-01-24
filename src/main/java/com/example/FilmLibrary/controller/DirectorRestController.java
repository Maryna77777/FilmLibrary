package com.example.FilmLibrary.controller;


import com.example.FilmLibrary.DTO.DirectorDTO;
import com.example.FilmLibrary.DTO.DirectorWhithAllRelatedEntitiesDTO;
import com.example.FilmLibrary.entity.Director;
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

    @GetMapping("/list")
   public List<DirectorDTO> findAllDirectors() {
     return directorService.getAllDirector();
 }

    @GetMapping("/allPage")
    public Page<Director> findAllDirectorsPage(@PageableDefault(sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        return directorService.getDirectorPage (pageable);
    }

    @GetMapping("/byId/{id}")
    public DirectorWhithAllRelatedEntitiesDTO findDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id);
    }

    @GetMapping("/byName/{lastName}")
    public DirectorWhithAllRelatedEntitiesDTO findDirectorByLastName(@PathVariable String lastNameDirector) {
        return directorService.getDirectorByLastName(lastNameDirector);
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


