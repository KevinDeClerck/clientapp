
package com.realdolmen.maven.clientrepository.facade;

import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.domain.Klant;
import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.FirmRepository;
import com.realdolmen.maven.clientrepository.repositories.PersonRepository;
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

import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class ClientFacadeTest {
    
   @Mock
   ClientFacade clientFacade;
   
   
    @Mock
    private PersonRepository personRepository;
   
   @Mock
   private PersonService personService;
   @Mock
   private FirmService firmService;
   
   
     
    @Mock
    private FirmRepository firmRepository;
    @Mock
    private PostalCodeService postalCodeService;
    @Mock
    private AddressService addressService;
    
   
    
    
    @Before
    public void init(){
        clientFacade = new ClientFacade(postalCodeService, addressService, personService, firmService);
        
    }
    
    
    @Test
    public void testGetAllClients() throws NoQueryPossibleException {
        List<Klant> clients = new ArrayList<>();
        
        List<Person> persons = new ArrayList<>();
        List<Firm> firms = new ArrayList<>();
        when(personService.findAll()).thenReturn(persons);
        when(firmService.findAll()).thenReturn(firms);
        for (Person p : persons){
            clients.add(p);
        }
        for (Firm f : firms){
            clients.add(f);
        }
        List<Klant> facades = clientFacade.getAllClients();
        assertEquals(clients, facades);
        verify(personService, times(1)).findAll();          
        verify(firmService, times(1)).findAll();          
    }
        
    @Test
    public void testFindClientById() throws NoQueryPossibleException {
        Person person = new Person();
        Firm firm = new Firm();
        
        when(personService.findById(1)).thenReturn(person);
        when(firmService.findById(1)).thenReturn(firm);
        Klant caseP = clientFacade.findClientById(1, 'p');
        Klant caseF = clientFacade.findClientById(1, 'f');
        assertEquals(person, caseP);
        assertEquals(firm, caseF);
        verify(personService, times(1)).findById(1);
        verify(firmService, times(1)).findById(1);    
    }
    
}
