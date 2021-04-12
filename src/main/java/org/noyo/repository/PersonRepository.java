package org.noyo.repository;

import org.noyo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends RevisionRepository<Person, Long, Integer>,  JpaRepository<Person, Long> {



}
