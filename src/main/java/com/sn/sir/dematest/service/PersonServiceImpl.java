package com.sn.sir.dematest.service;

import com.sn.sir.dematest.model.Person;
import com.sn.sir.dematest.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    Logger logger= (Logger) LoggerFactory.getLogger(PersonServiceImpl.class);

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public Person getPerson(int id) {
        Optional<Person> response=personRepository.findById(id);
        return response.orElse(null);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
