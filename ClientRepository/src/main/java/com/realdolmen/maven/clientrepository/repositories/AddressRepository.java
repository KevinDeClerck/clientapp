package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.domain.PostalCode;
import static com.realdolmen.maven.clientrepository.repositories.PersonRepository.FIRST_NAME;
import static com.realdolmen.maven.clientrepository.repositories.PersonRepository.KEY;
import static com.realdolmen.maven.clientrepository.repositories.PersonRepository.NAME;
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
        try {
            address.setNumber(resultSet.getInt(KEY));
            address.setTypeAddress(resultSet.getString(TYPE));
            address.setStreet(resultSet.getString(STREET));
            address.setNumber(resultSet.getInt(NUMBER));
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
        if(c.getKlant() instanceof Person){
            return "("+c.getKlant().getNumber()+","+null+"(";
            
        }else if(c.getKlant() instanceof Firm){
            return "("+","+null+c.getKlant().getNumber()+"(";
    }
    return "";
    
}
}

