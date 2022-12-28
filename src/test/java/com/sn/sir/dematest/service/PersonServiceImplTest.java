package com.sn.sir.dematest.service;

import com.sn.sir.dematest.model.Person;
import com.sn.sir.dematest.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    @Test
    void createPerson() {
        //Given
        Person person = new Person("Moussa", "tonux@gmail.com", "123456");
        person.setId(1);
        when(personRepository.save(any())).thenReturn(person);

        //When
        Person personResponse = personService.createPerson(person);

        //Then
        assertEquals("Moussa", personResponse.getName());
        assertEquals(1, personResponse.getId());
        verify(personRepository, atLeastOnce()).save(any());
    }

    @Test
    void updatePerson() {
        //TODO : implement this test
    }

    @Test
    void deletePerson() {
        //TODO : implement this test
    }

    @Test
    void getPerson() {
        //TODO : implement this test
    }

    @Test
    void getAllPersons() {
        //TODO : implement this test
    }
}