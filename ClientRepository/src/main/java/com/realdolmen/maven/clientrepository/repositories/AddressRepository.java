package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Address;
import java.sql.ResultSet;



public class AddressRepository extends AbstractRepository<Address, Integer>{

    //private static final String TABLE;
    
    public AddressRepository() {
        super("address", "");
    }
    
    protected AddressRepository(String url){
        super("","","");
    }

    //TODO implement
    @Override
    public Address createObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO implement
    @Override
    public String getColumnString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO implement
    @Override
    public String getValuesString(Address c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
