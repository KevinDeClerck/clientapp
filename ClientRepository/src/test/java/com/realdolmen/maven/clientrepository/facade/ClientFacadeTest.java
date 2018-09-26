/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.maven.clientrepository.facade;

import com.realdolmen.maven.clientrepository.domain.Klant;
import com.realdolmen.maven.clientrepository.domain.PostalCode;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.AbstractRepositoryTest;
import com.realdolmen.maven.clientrepository.repositories.FirmRepository;
import com.realdolmen.maven.clientrepository.repositories.PersonRepository;
import com.realdolmen.maven.clientrepository.repositories.PostalCodeRepository;
import com.realdolmen.maven.clientrepository.services.PersonService;
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
 *
 * @author SDOAX36
 */

@RunWith(MockitoJUnitRunner.class)
public class ClientFacadeTest {
    
     @Mock
    private ClientFacade clientFacade;

    @Before
    public void init() {
       
        clientFacade = new ClientFacade();
    }


    public ClientFacadeTest() {
    
    }

    /**
     * Test of getAllClients method, of class ClientFacade.
     */
    @Test
    public void testGetAllClients() {     
    }

    /**
     * Test of findClientById method, of class ClientFacade.
     */
    @Test
    public void testFindClientById() throws NoQueryPossibleException{
        
        //test van findClientById method, of class ClientFacade
      Klant klant = null;
      PersonRepository personRepository  = new PersonRepository();
     
       
        
        
        FirmRepository firmRepository = new FirmRepository();
        
        
      
        
    }
    
}
