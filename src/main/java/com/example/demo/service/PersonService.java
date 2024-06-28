package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    //get a reference of the actual person DAO

    private final PersonDao personDao;
    // the qualifier acts like a tag, as the PersonDao interface could be implemented by multiple classes, the qualifier helps to specify which class used it.
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }


    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person newPerson){
        return personDao.updatePerson(id, newPerson);
    }


}
