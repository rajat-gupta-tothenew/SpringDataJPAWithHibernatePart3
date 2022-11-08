package org.ttn.springhibernatepart3.manyToMany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ttn.springhibernatepart3.manyToMany.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Integer> {

}
