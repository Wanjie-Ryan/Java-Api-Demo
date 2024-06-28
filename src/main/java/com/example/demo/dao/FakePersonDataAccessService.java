package com.example.demo.dao;


import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDAO")
// this class will implement the PersonDao interface
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {

        DB.add(new Person(id, person.getName()));

        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    // over here, you search if the id exists in the DB, and compare it to the existing id.
    @Override
    public Optional<Person> selectPersonById(UUID id) {
//        return Optional.empty();
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        //we first map the person, and if the index of the person found is greater than or equal to 0 then we found the person and we set the found person to the content that has been passed in by the client.
        return selectPersonById(id).map(user ->{
            int indexOfPersonToUpdate = DB.indexOf(user);
            if(indexOfPersonToUpdate >= 0){
                DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        })
                .orElse(0);
    }

    // in the delete method, check if the person exists, if exists delete, if not return 0;
    @Override
    public int deletePersonById(UUID id) {
        // the optional is kind of a return statement
        Optional <Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }
}
