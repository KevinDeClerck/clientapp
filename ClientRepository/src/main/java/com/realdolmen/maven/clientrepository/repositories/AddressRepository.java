package com.realdolmen.maven.clientrepository.repositories;


import com.realdolmen.maven.clientrepository.domain.*;
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
        if (c.getKlant() instanceof Person){
            //client person
            return "("+null+","+c.getKlant().getNumber()+","+null+")";
        }else if (c.getKlant()instanceof Firm){
            return "("+null+","+c.getKlant().getNumber()+")";
        }
        return "";
    }
    
    
    
}
