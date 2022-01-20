package com.example.FilmLibrary.DTO;


import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableTransactionManagement
@Getter
@Setter
public class GenreDTO {
    private long id;
    private String category;

}
