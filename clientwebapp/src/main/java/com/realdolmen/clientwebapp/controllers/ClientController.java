
package com.realdolmen.clientwebapp.controllers;

import com.realdolmen.maven.clientrepository.facade.ClientFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ClientController {
    
    private ClientFacade facade;
    
    public ClientController(ClientFacade facade){
        Logger logger = LoggerFactory.getLogger(Object.class);
    }
}
