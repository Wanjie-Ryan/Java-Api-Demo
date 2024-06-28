package com.example.demo.dao;

// Defining Database Operations: The PersonDao interface defines methods for interacting with the database. Implementing classes will provide the actual logic for these methods, such as connecting to the database, executing queries, and handling results.
//Abstraction: By defining an interface, you create a layer of abstraction. This allows you to switch between different database implementations or mock the database operations for testing purposes without changing the business logic.


import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// we will implement the operations allowed on the DB, we switch between DBs using the dependency injections
public interface PersonDao {

    // create 2 methods for inserting a person to a DB, the first method inserts a person to the DB using an id while the second one generates a unique id and then inserts the user to the DB
    int insertPerson (UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    // the int, List, identifies the return type of the method
    List<Person> selectAllPeople();

    // inside the brackets, you define what you want to manipulate.
    Optional<Person> selectPersonById(UUID id);

    int updatePerson(UUID id, Person person);

    int deletePersonById(UUID id);

}
