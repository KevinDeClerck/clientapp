package com.realdolmen.maven.clientrepository.repositories;


import com.realdolmen.maven.clientrepository.domain.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AddressRepository extends AbstractRepository<Address, Integer>{

    public static final String TABLE_NAME = "client_address";
    public static final String KEY = "id";
    public static final String TYPE = "type";
    public static final String NUMBER = "number";
    public static final String BOX = "box";
    public static final String STREET = "street";
    public static final String POSTALCODE = "postal_code";
    public static final String PERSON = "client_person";
    public static final String FIRM = "client_firm";
    
    
    public AddressRepository() {
        super("address", "");
    }
    
    protected AddressRepository(String url){
        super("","","");
    }

    //TODO implement
    @Override
    public Address createObject(ResultSet resultSet) {
        
        Address address = new Address();
        PostalCode postalCode = new PostalCode();
        try {
            address = new Address();
            address.setNumber(resultSet.getInt(KEY));
            address.setTypeAddress(resultSet.getString(TYPE));
            address.setNumber(resultSet.getInt(NUMBER));
            address.setNumber(resultSet.getInt(BOX));
            address.setStreet(resultSet.getString(STREET));
            postalCode.setNumber(resultSet.getInt(POSTALCODE));
            address.setNumber(resultSet.getInt(PERSON));
            address.setNumber(resultSet.getInt(FIRM));
            return address;
        } catch (SQLException ex) {
            Logger.getLogger(PersonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return address;
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



