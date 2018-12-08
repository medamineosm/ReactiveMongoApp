package com.osm.guru.reactive.mongo.app.repository;

import com.osm.guru.reactive.mongo.app.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Created by Ouasmine on 08/12/2018.
 */
@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, String>{

    Flux<Person> GetPersonByFirstName(String firstName);
}
