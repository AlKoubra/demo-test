package com.sn.sir.dematest.controller;

import com.sn.sir.dematest.model.Person;
import com.sn.sir.dematest.service.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    /**
     * - GET /api/person
     * - GET /api/person/{id}
     * - POST /api/person
     * - PUT /api/person/{id}
     * - DELETE /api/person/{id}
     */

    PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @RequestParam int id) {
        Person updateperson= personService.getPerson(id);
        if(updateperson==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personService.updatePerson(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@RequestParam int id) {
        personService.deletePerson(personService.getPerson(id));
        return ResponseEntity.ok().build();
    }


    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello "+name;
    }

}
