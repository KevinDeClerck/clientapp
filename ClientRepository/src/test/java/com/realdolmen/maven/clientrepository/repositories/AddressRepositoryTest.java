
package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.domain.Firm;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class AddressRepositoryTest {
    
    private AddressRepository addressRepository;
    
    @Mock
    private ResultSet resultSet;
    
    @Before
    public void init(){
        addressRepository = new AddressRepository(AbstractRepositoryTest.URL);
    }
   
     @Test
        public void createObjectAddressTestSuccess() throws SQLException {
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
                .thenReturn(4567);
        when(resultSet.getInt(AddressRepository.FIRM))
                .thenReturn(1234);
        Address result = addressRepository.createObject(resultSet);
        assertEquals(1234,result.getNumber());
        assertEquals("straat", result.getStreet());
        assertEquals("home", result.getTypeAddress());
        
    }
 
    @Test
    public void testGetColumnString() {
    }


    @Test
    public void testGetValuesString() {
    }
    
}
