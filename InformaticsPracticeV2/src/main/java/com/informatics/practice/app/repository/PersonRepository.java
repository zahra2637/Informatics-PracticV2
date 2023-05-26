package com.informatics.practice.app.repository;
import com.informatics.practice.app.entity.Person;
import org.springframework.data.repository.CrudRepository;



public interface PersonRepository extends CrudRepository<Person, Long> {

}
