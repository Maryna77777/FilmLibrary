package com.example.FilmLibrary;

import com.example.FilmLibrary.entity.Actor;


import com.example.FilmLibrary.entity.Actor_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ActorSpecification {
    public static Specification<Actor> getActor(String lastName) {
        return new Specification<Actor>() {

            @Override
            public Predicate toPredicate(Root<Actor> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate equalPredicate = criteriaBuilder.equal(root.get(Actor_.lastName), lastName);
                return equalPredicate;
            }
        };
    }
}

