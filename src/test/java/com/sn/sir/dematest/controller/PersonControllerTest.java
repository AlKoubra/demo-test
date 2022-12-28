package com.sn.sir.dematest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sn.sir.dematest.model.Person;
import com.sn.sir.dematest.repository.PersonRepository;
import com.sn.sir.dematest.service.PersonService;
import org.apache.catalina.filters.ExpiresFilter;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonController personController;


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PersonService personService;

    @LocalServerPort
    private int port;

    PersonControllerTest() {
    }

    @Test
     void Hello(){
        String name= "tonux";
        String url = "http://localhost:" + port + "/api/person/hello?name="+name;
        String response = restTemplate.getForObject(url, String.class);
        assertEquals("Hello "+name, response);
    }

    @Test
    void getAllPerson() throws Exception {
        //Given
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/person")
                .contentType(MediaType.APPLICATION_JSON);

        //When
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        //Then
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void getPerson() throws Exception {

        personService.getPerson(3);
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8088/api/person/%7Bid%7D?id=3")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());



    }

    @Test
    void createPerson() throws Exception {
        // TODO : add test createPerson
        Person person=new Person();
        person.setId(5);
        person.setName("Ndéye Khady Niang");
        person.setEmail("xadyniangnd@gmail.com");
        person.setPhone("782115910");

        personService.createPerson(person);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/person")
                        .content(new ObjectMapper().writeValueAsString(person))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ndéye Khady Niang"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("xadyniangnd@gmail.com"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("782115910"));

    }

    @Test
    void updatePerson() throws Exception {
        // TODO : add test updatePerson
        Person person=new Person();
        person.setId(1);
        person.setName("Ndéye Khady Niang");
        person.setEmail("xadyniangnd@gmail.com");
        person.setPhone("782115910");

        personService.updatePerson(person);

        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8088/api/person/%7Bid%7D?id=2")
                        .content(new ObjectMapper().writeValueAsString(person))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ndéye Khady Niang"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("xadyniangnd@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("782115910"));



    }

    @Test
    void deletePerson() throws Exception {
        // TODO : add test deletePerson
        when(personService.getPerson(3)).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("http://localhost:8088/api/person/%7Bid%7D?id=3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}