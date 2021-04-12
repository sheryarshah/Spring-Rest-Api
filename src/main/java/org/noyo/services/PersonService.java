package org.noyo.services;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.noyo.exceptions.PersonNotFoundException;
import org.noyo.models.Person;
import org.noyo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public PersonService() {
    }


    /**
     * Get List of persons from the db
     *
     * @return list of person
     */
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    /**
     * Save person to the db
     *
     * @param person
     * @return saved person object
     */
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    /**
     * Finds person by id
     *
     * @param id
     * @return person if found, else throw error message exception
     */
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    /**
     * Delete person by id
     *
     * @param id
     */
    public void deletePersonById(Long id) {
        if (personRepository.existsById(id)) personRepository.deleteById(id);
        else throw new PersonNotFoundException(id);
    }


    public List<Person> getPersonEditVersions(Long id) {

        List<Person> versionList = new ArrayList<>();

        personRepository.findRevisions(id).get().forEach(x -> {
            x.getEntity().setEditVersion(x.getMetadata());
            versionList.add(x.getEntity());
        });

        return versionList;
    }

    public Person getPersonVersion(Long personId, int versionId) {
        Person p = personRepository.findRevision(personId, versionId).get().getEntity();

        return p;

    }

    /**
     * Updates person by id
     *
     * @param p
     * @param id
     * @return updated person
     */
    public Person updatePersonById(Person p, Long id) {

        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()) {
            person.get().setFirstName(p.getFirstName() != null ? p.getFirstName() : person.get().getFirstName());
            person.get().setMiddleName(p.getMiddleName() != null ? p.getMiddleName() : person.get().getMiddleName());
            person.get().setLastName(p.getLastName() != null ? p.getLastName() : person.get().getLastName());
            person.get().setEmail(p.getEmail() != null ? p.getEmail() : person.get().getEmail());
            person.get().setAge(p.getAge());
        }

        return person.isPresent() ? personRepository.save(person.get()) : null;

    }


}
