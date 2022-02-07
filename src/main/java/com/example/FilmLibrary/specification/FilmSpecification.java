package com.example.FilmLibrary.specification;

import com.example.FilmLibrary.entity.*;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilmSpecification {

    public static Specification<Film> getFilmsAllSpecification(String title, int year, String country, String genre) {
        return new Specification<Film>() {
            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (title != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get(Film_.title), "%" + title + "%")));
                }
                if (year != 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(Film_.YEAR), year)));
                }
                Join<Film, Country> countryJoin =  root.join(Film_.country);
                if (country != null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(countryJoin.get(Country_.NAME), country)));
                }
                ListJoin<Film, Genre> genreJoin =  root.join(Film_.genres);
                if (genre !=null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(genreJoin.get(Genre_.category), genre)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }

    public static Specification<Film> getFilmsAllSpecification1(String title, int year, String country, String genre) {
        return new Specification<Film>() {
            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (title != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get(Film_.title), "%" + title + "%")));
                }
                if (year != 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(Film_.YEAR), year)));
                }
                Join<Film, Country> countryJoin =  root.join(Film_.country);
                if (country != null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(countryJoin.get(Country_.NAME), country)));
                }
                ListJoin<Film, Genre> genreJoin =  root.join(Film_.genres);
                if (genre !=null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(genreJoin.get(Genre_.category), genre)));
                }

                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
        };
    }

    public static Specification<Film> getFilmsSpecification(String title, String country, String genre) {
        return new Specification<Film>() {
            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (title != null) {
                   predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%"+title+"%")));
                }
                Join<Film, Country> countryJoin =  root.join(Film_.country);
                if (country != null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(countryJoin.get(Country_.NAME), country)));
                }
                ListJoin<Film, Genre> genreJoin =  root.join(Film_.genres);
                if (genre !=null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(genreJoin.get(Genre_.category), genre)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }
            };
        }

    public static Specification<Film> getFilmsSpecificationJoinCountry (String name){
        return new Specification<Film>() {
            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Film, Country> countryJoin =  root.join(Film_.country);
                Predicate equalPredicate = criteriaBuilder.equal(countryJoin.get(Country_.NAME), name);
                return equalPredicate;
            }
        };
    }

}
