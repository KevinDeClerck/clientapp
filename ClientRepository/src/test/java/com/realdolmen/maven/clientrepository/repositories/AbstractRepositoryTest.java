/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import java.util.List;
import org.junit.Assert;

/**
 *
 * @author SDOAX36
 * @param C an implementation of AbstractRepository
 * @param T an implementation of a Class in Domain
 */
public class AbstractRepositoryTest <C extends AbstractRepository,T>{
    
    static String URL = "jdbc:mysql://localhost:3306/clientdbtest?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    protected C repository;
    
    public void someTest() throws NoQueryPossibleException{
        List<T> t = repository.findAll();
        Assert.assertFalse(t.isEmpty());
    }
}
