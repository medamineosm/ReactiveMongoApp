package com.osm.guru.reactive.mongo.app.service;

import com.osm.guru.reactive.mongo.app.model.Person;
import com.osm.guru.reactive.mongo.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Flux<Person> findAll(){
        return personRepository.findAll();
    }
}
