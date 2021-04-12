package org.noyo.controllers;

import org.noyo.exceptions.HttpException;
import org.noyo.models.Person;
import org.noyo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String home() {
        return "Welcome To Noyo Challenge. By Sheryar Shah!!!";
    }

    @PostMapping("/persons")
    public Person newPerson(@RequestBody Person newPerson) {
        return personService.savePerson(newPerson);
    }

    @GetMapping("persons/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("persons/{id}/version")
    public List<Person> getPersonVersions(@PathVariable Long id) {
        return personService.getPersonEditVersions(id);
    }

    @GetMapping("persons/version")
    public Person getPersonByIdVersion(@RequestParam Map<String, String> params) {
        Long id = Long.valueOf(params.get("id"));
        int version = Integer.valueOf(params.get("version"));
        return personService.getPersonVersion(id, version);

    }

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPerson() throws HttpException {
        return personService.getAllPerson();
    }

    @PutMapping("persons/{id}")
    public Person updatePersonById(@RequestBody Person person, @PathVariable Long id) {
        return personService.updatePersonById(person, id);
    }

    @DeleteMapping("persons/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }


}
