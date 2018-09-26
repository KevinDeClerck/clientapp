package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author SDOAX36
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void init() {
        personService = new PersonService(personRepository);
    }

    @Test
    public void findAllPersonTestSucces() throws NoQueryPossibleException {
        List<Person> persons = new ArrayList<>();
        when(personRepository.findAll()).thenReturn(persons);
        List<Person> result = personService.findAll();
        assertEquals(persons, result);
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void findByIDTest() throws NoQueryPossibleException {
        Person person = new Person();
        when(personRepository.findById(1)).thenReturn(person);
        Person result = personService.findById(1);
        assertEquals(person, result);
        verify(personRepository, times(1)).findById(1);


    }

    @Test
    public void testRemovePerson() throws NoQueryPossibleException {
        Person person = new Person();
        person.setNumber(1);
        personService.removePerson(person);
        verify(personRepository, times(1)).deleteItem(person.getNumber());
    }

    @Test
    public void insertPersonTest() throws Exception {
        Person person = new Person();
        person.setNumber(1);
        when(personRepository.insertItem(person)).thenReturn(1);
        when(personRepository.findById(1)).thenReturn(person);
        Person result = personService.insertPerson(person);
        assertEquals(result, person);
        verify(personRepository, times(1)).insertItem(person);
    }
}
