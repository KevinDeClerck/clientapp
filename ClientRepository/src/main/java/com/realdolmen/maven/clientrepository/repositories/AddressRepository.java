package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressRepository extends AbstractRepository<Address, Integer> {

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

    protected AddressRepository(String url) {
        super("", "", "");
    }

    @Override
    public Address createObject(ResultSet resultSet) {

        Address address = new Address();
        PostalCode postalCode = new PostalCode();
        Klant klant;
        try {
            postalCode = new PostalCode();
            address = new Address();
            klant = new Klant();
            address.setKey(resultSet.getInt(KEY));
            address.setTypeAddress(resultSet.getString(TYPE));
            address.setNumber(resultSet.getInt(NUMBER));
            address.setBox(resultSet.getInt(BOX));
            address.setStreet(resultSet.getString(STREET));
            postalCode.setNumber(resultSet.getInt(POSTALCODE));
            address.setPostalCode(postalCode);
            int iPerson = resultSet.getInt(PERSON);
            int iFirm = resultSet.getInt(FIRM);
            if (iPerson > 0) {
                klant.setNumber(iPerson);
                address.setKlant(klant);
            } else if (iFirm > 0) {
                klant.setNumber(iFirm);
                address.setKlant(klant);
            }
            return address;
        } catch (SQLException ex) {
            Logger.getLogger(PersonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return address;
    }

    @Override
    public String getColumnString() {
        return "(" + KEY + "," + TYPE + "," + STREET + "," + NUMBER + "," + BOX +  "," + POSTALCODE + "," + PERSON + "," + FIRM + ")";
    }

    @Override
    public String getValuesString(Address c) {
        if (c.getKlant() instanceof Person) {
            return "(" + null + "," + c.getKlant().getNumber() + "," + null + ")";
        } else if (c.getKlant() instanceof Firm) {
            return "(" + null + "," + c.getKlant().getNumber() + ")";
        }
        return "";
    }
}
