package com.sn.sir.dematest.service;

import com.sn.sir.dematest.model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(Person person);
    Person getPerson(int id);
    List<Person> getAllPersons();
}
