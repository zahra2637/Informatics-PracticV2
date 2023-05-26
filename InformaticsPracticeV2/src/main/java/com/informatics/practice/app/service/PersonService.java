package com.informatics.practice.app.service;
import com.informatics.practice.app.entity.Person;
import com.informatics.practice.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService  {
    PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person createOrUpdate(Person person){
        return personRepository.save(person);
    }

    public Person delete(Long id){
        Optional<Person> inventory = personRepository.findById(id);
        personRepository.delete(inventory.get());
        return inventory.get();
    }

    public Iterable<Person> getAll(){
        return personRepository.findAll();
    }
}
