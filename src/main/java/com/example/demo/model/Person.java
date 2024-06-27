package com.example.demo.model;

import java.util.UUID;

public class Person {


    // we define the models over here

    private final UUID id;
    private final String name;


    // create a constructor
    //The main purpose of a constructor is to set up the initial state of an object. This typically involves initializing the object's fields (or instance variables) to specific values.
//    A constructor has the same name as the class in which it is defined. This is how the Java runtime system distinguishes it from other methods.
    public Person(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    //creating getters for the models
    // These are getter methods that provide access to the private fields
    public UUID getId(){
        return id;
    }

    public String getName (){
        return name;
    }




}
