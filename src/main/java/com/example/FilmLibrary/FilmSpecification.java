//package com.example.FilmLibrary;
//
//import com.example.FilmLibrary.entity.Film;
//import com.example.FilmLibrary.service.FilmService;
//import lombok.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class FilmSpecification {
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

