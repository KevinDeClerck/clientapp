
package com.realdolmen.maven.clientrepository.facade;

import com.realdolmen.maven.clientrepository.domain.Klant;
import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.services.AddressService;
import com.realdolmen.maven.clientrepository.services.FirmService;
import com.realdolmen.maven.clientrepository.services.PersonService;
import com.realdolmen.maven.clientrepository.services.PostalCodeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class ClientFacadeTest {
    
   private ClientFacade clientFacade;
   
    @Mock
    private PostalCodeService postalCodeService;
    private AddressService addressService;
    private PersonService personService;
    private FirmService firmService;
    
    @Before
    public void init(){
        clientFacade = new ClientFacade();
    }
    
    @Test
    public void testGetAllClients() throws NoQueryPossibleException {
    
        //data initialiseren
        List<Person> persons = new ArrayList<>();
        when(personService.findAll()).thenReturn(persons);

        //Test the method
        List<Klant> result = clientFacade.getAllClients();
        //verify
        assertEquals(persons, result);
        //verify(personService, times(1)).findAll();
    }
        
    @Test
    public void testFindClientById() {
    }
    
}
