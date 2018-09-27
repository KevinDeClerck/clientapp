
package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class PersonRepositoryTest {
    
     private PersonRepository personRepository;
     
    @Mock
    private ResultSet resultSet;
    
    @Before
    public void init(){
        personRepository = new PersonRepository();
    }
    
    @Test
    public void testFindAll() throws NoQueryPossibleException{
        PersonRepository personRepository = new PersonRepository();
        List<Person> persons = personRepository.findAll();
        assertFalse(persons.isEmpty());
    }
    
     @Test
    public void createObjectPersonTestSuccess() throws SQLException {
        //initialiseren data
        when(resultSet.getInt(PersonRepository.KEY))
                .thenReturn(1);
        when(resultSet.getString(PersonRepository.NAME))
                .thenReturn("Tintin");
        when(resultSet.getString(PersonRepository.FIRST_NAME))
                .thenReturn("Kuifje");
        Person result = personRepository.createObject(resultSet);
        //verify the result
        assertEquals(1,result.getNumber());
        assertEquals("Tintin", result.getName());
        assertEquals("Kuifje", result.getFirstName());
        verify(resultSet,times(1)).getInt(PersonRepository.KEY);
        verify(resultSet,times(1)).getString(PersonRepository.NAME);
        verify(resultSet,times(1)).getString(PersonRepository.FIRST_NAME);
    }
    
       @Test
    public void createObjectTestThrowsSQLException() throws SQLException{
        when(resultSet.getInt(PersonRepository.KEY)).thenThrow(SQLException.class);
        //test the object
        Person result = personRepository.createObject(resultSet);
        
        //verify the result 
        verify(resultSet,times(1)).getInt(PersonRepository.KEY);
        verifyNoMoreInteractions(resultSet);
    }
    
}
