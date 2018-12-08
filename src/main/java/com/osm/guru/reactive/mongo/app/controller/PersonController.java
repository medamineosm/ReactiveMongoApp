package com.osm.guru.reactive.mongo.app.controller;

import com.osm.guru.reactive.mongo.app.model.Person;
import com.osm.guru.reactive.mongo.app.service.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Ouasmine on 08/12/2018.
 */
@RestController
@RequestMapping("Person")
public class PersonController {

    private final PersonDao personDao;

    @Autowired
    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("findAll")
    public Flux<Person> findAll(){
        return personDao.findAll();
    }

    @PutMapping("saveOne")
    public Mono<Person> saveOne(@RequestBody Person person){
        return personDao.saveOne(person);
    }
}
