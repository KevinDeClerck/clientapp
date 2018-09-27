package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.domain.Klant;
import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.domain.PostalCode;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.BOX;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.FIRM;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.KEY;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.NUMBER;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.PERSON;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.POSTALCODE;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.STREET;
import static com.realdolmen.maven.clientrepository.repositories.AddressRepository.TYPE;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class AddressRepositoryTest {

    
    private AddressRepository addressRepository;

    @Mock
    private ResultSet resultSet;
    
    
    @Mock
    private PostalCode postalCode;

    @Before
    public void init() {
        addressRepository = new AddressRepository(AbstractRepositoryTest.URL);
        postalCode = new PostalCode();
    }
    
    
    @Test
    public void createObjectAddressTestSuccessFirm() throws SQLException {
        PostalCode postalCode = new PostalCode();
        Klant klantA = new Person();
        Klant klantB = new Firm();
        
        when(resultSet.getInt(AddressRepository.KEY))
                .thenReturn(1);
        when(resultSet.getString(AddressRepository.TYPE))
                .thenReturn("home");
        when(resultSet.getInt(AddressRepository.NUMBER))
                .thenReturn(123);
        when(resultSet.getInt(AddressRepository.BOX))
                .thenReturn(12);
        when(resultSet.getString(AddressRepository.STREET))
                .thenReturn("straat");
        when(resultSet.getInt(AddressRepository.POSTALCODE))
                .thenReturn(2000);
        when(resultSet.getInt(AddressRepository.PERSON))
                .thenReturn(0);
        when(resultSet.getInt(AddressRepository.FIRM))
                .thenReturn(1234);
        
        
        Address result = addressRepository.createObject(resultSet);
        

        postalCode = result.getPostalCode();
        klantA = result.getKlant();
        klantB = result.getKlant();

        assertEquals(1, result.getKey());
        assertEquals("home", result.getTypeAddress());
        assertEquals("straat", result.getStreet());
        assertEquals(123, result.getNumber());
        assertEquals(12, result.getBox());
        assertEquals(2000, postalCode.getNumber());
        assertEquals(1234, klantB.getNumber());
    }
    
    
    @Test
    public void createObjectAddressTestSuccessPerson() throws SQLException {
        PostalCode postalCode = new PostalCode();
        Klant klantA = new Person();
        Klant klantB = new Firm();
        
        when(resultSet.getInt(AddressRepository.KEY))
                .thenReturn(1);
        when(resultSet.getString(AddressRepository.TYPE))
                .thenReturn("home");
        when(resultSet.getInt(AddressRepository.NUMBER))
                .thenReturn(123);
        when(resultSet.getInt(AddressRepository.BOX))
                .thenReturn(12);
        when(resultSet.getString(AddressRepository.STREET))
                .thenReturn("straat");
        when(resultSet.getInt(AddressRepository.POSTALCODE))
                .thenReturn(2000);
        when(resultSet.getInt(AddressRepository.PERSON))
                .thenReturn(12345);
        when(resultSet.getInt(AddressRepository.FIRM))
                .thenReturn(0);
        
        
        Address result = addressRepository.createObject(resultSet);
        

        postalCode = result.getPostalCode();
        klantA = result.getKlant();
        klantB = result.getKlant();

        assertEquals(1, result.getKey());
        assertEquals("home", result.getTypeAddress());
        assertEquals("straat", result.getStreet());
        assertEquals(123, result.getNumber());
        assertEquals(12, result.getBox());
        assertEquals(2000, postalCode.getNumber());
        assertEquals(12345, klantB.getNumber());
    }

    @Test
    public void testGetColumnString() {
        String test = addressRepository.getColumnString();
        assertEquals(test, "(id,type,street,number,box,postal_code,client_person,client_firm)");      
    }

    @Test
    public void testGetValuesString() {
        Klant klantP = new Person("Kevin", "De Clerck", 20);
        Klant klantF = new Firm("Realdolmen", "IT", 15);
        Address addressP = new Address(1, "Warmoensberg", 36, klantP);
        Address addressF = new Address(2, "Ninoofse steenweg", 2, klantF);
        
        String resultP = addressRepository.getValuesString(addressP);
        String resultF = addressRepository.getValuesString(addressF);
        
        assertEquals(resultP,"(" + null + "," + 20 + "," + null + ")" );
        assertEquals(resultF, "(" + null + "," + 15 + ")");     
    }
}
