package com.osm.guru.reactive.mongo.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Ouasmine on 08/12/2018.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Person {

    @Id
    private String id;
    private String firstName;
    private String listName;
    private int age;
}
