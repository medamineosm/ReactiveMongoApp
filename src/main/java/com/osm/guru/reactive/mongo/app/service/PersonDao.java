package com.osm.guru.reactive.mongo.app.service;

import com.osm.guru.reactive.mongo.app.model.Person;
import com.osm.guru.reactive.mongo.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Created by Ouasmine on 08/12/2018.
 */
@Service
public class PersonDao {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<Person> saveOne(Person person){
        return personRepository.save(person);
    }

    public Flux<Person> saveAll(Collection<Person> persons){
        return personRepository.saveAll(persons);
    }

    public Flux<Person> saveFlux(Flux<Person> persons){
        return personRepository.saveAll(persons);
    }

    public Flux<Person> findAll(){
        return personRepository.findAll();
    }

    public Flux<Person> getPersonByFirstName(String firstName){
        return personRepository.getPersonByFirstName(firstName);
    }
}
