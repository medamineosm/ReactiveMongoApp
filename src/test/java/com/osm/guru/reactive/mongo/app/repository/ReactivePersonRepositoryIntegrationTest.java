package com.osm.guru.reactive.mongo.app.repository;

import com.osm.guru.reactive.mongo.app.model.Person;
import com.osm.guru.reactive.mongo.app.service.PersonDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReactivePersonRepositoryIntegrationTest {

    @Autowired
    PersonDao personDao;
    @Autowired
    ReactiveMongoOperations mongoOperations;

    @Before
    public void setUp(){
        mongoOperations.collectionExists(Person.class)
                .flatMap(exist -> exist ? mongoOperations.dropCollection(Person.class) : Mono.just(exist))
                .flatMap(o -> mongoOperations.createCollection(Person.class))
                .then()
                .block();

        personDao.saveFlux(Flux.just(
                new Person("medamineosm", "ouasmine", "mohammed amine", 26),
                new Person("bastard", "jhon", "snow", 27)))
                .then()
                .block();
    }

    @Test
    public void getPersonByFirstNameTest() {
        Flux<Person> persons = personDao.getPersonByFirstName("ouasmine");
    }
}
