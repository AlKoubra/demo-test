package com.sn.sir.dematest.repository;

import com.sn.sir.dematest.model.Person;
import nonapi.io.github.classgraph.utils.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create(){
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        assertNotNull(person);
        assertEquals("tonux", person.getName());
    }

    @Test
    void update(){
        //Given
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        person.setName("Coundoul");
        //When
        Person personUpdated = personRepository.save(person);
        //Then
        assertNotNull(personUpdated);
        assertEquals("Coundoul", personUpdated.getName());
    }
    // TODO : add test delete
    @Test
    void delete(){
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        personRepository.delete(person);
        assertNotNull(personRepository.findById(person.getId()));

    }

    // TODO : add test findById
    @Test
    void findById(){
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        personRepository.findById(person.getId());
        assertNotNull(personRepository.findById(person.getId()));
    }

    // TODO : add test findAll
    @Test
    void findAll(){
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        personRepository.findAll();
        assertNotNull(personRepository.findAll());
    }
}