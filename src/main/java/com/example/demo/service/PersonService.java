package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    //get a reference of the actual person DAO

    private final PersonDao personDao;
    // the qualifier acts like a tag, as the PersonDao interface could be implemented by multiple classes, the qualifier helps to specify which class used it.
    @Autowired
    public PersonService(@Qualifier("fakeDAO") PersonDao personDao) {
        this.personDao = personDao;
    }


    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
