package com.example.FilmLibrary;

import com.example.FilmLibrary.entity.Country;

import com.example.FilmLibrary.entity.Film;

import com.example.FilmLibrary.service.FilmService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilmSpecification {

    public static Specification<Film> getFilmsSpecification(String title, int year) {
        return new Specification<Film>() {

            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (title != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get(Film_.title), "%" + title + "%")));
                    //               predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%"+title+"%")));
                }
                if (year != 0) {

                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(Film_.YEAR), year)));
                    //              predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("year"), year)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }
            };
        }

    public static Specification<Film> getFilmsSpecificationJoinCountry (String name){
        return new Specification<Film>() {
            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                ListJoin<Film, Country> countryJoin = (ListJoin<Film, Country>) root.join(Film_.country);
                Predicate equalPredicate = criteriaBuilder.equal(countryJoin.get(Country_.NAME), name);
                return equalPredicate;
            }
        };
    }

}






//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    private FilmService service;
//    private final @NonNull FilmService.FilmFilter filter;
//
//
//           public Specification<Film> getFilmsSpecification(FilmService.FilmFilter filter) {
//                return (root, query, criteriaBuilder) -> {
//                        List<Predicate> predicates = new ArrayList<>();
//                        if (filter.getTitle() != null) {
//                                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + filter.getTitle() + "%"));
//                        }
//                        if (filter.getYear() != 0) {
//                                predicates.add(criteriaBuilder.equal(root.get("year"), filter.getYear()));
//                        }
//                        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//                };
//        }
//}




//        public static Specification<Film> getFilmsSpecification(Film film) {
//                return (root, query, criteriaBuilder) -> {
//                        List<Predicate> predicates = new ArrayList<>();
//                        if (film.getTitle() != null) {
//                                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + film.getTitle() + "%"));
//                        }
//                        if (film.getYear() != 0) {
//                                predicates.add(criteriaBuilder.equal(root.get("year"), film.getYear()));
//                        }
//                        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//                };
//        }
//}


//    public static Specification<Film> getFilm(String title) {
//        return new Specification<Film>() {
//            @Override
//            public Predicate toPredicate(Root<Film> root,
//                                         CriteriaQuery<?> query,
//                                         CriteriaBuilder criteriaBuilder) {
//
//                Predicate equalPredicate = criteriaBuilder.equal(root.get(Film_.title), title);
//                return equalPredicate;
//            }
//        };
//    }
//}

