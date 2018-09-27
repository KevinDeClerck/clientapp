package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.domain.Person;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.AddressRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {
    
    private AddressService addressService;
    
    @Mock
    private AddressRepository addressRepository;
    
    @Before
    public void init(){
        addressService = new AddressService(addressRepository);
    }

    @Test
    public void findAddressByIdTestSuccess() throws NoQueryPossibleException{
        Address address = new Address();
        when(addressRepository.findById(1)).thenReturn(address);
        Address result = addressService.findAddressById(1);
        assertEquals(address, result);
        verify(addressRepository,times(1)).findById(1);
    }
    
    @Test
    public void findAllAddressTestSucces() throws NoQueryPossibleException{
        List<Address> addressList = new ArrayList<>();
        when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> result = addressService.findAllAddress();
        assertEquals(addressList, result);
        verify(addressRepository, times (1)).findAll();
    }
    
    @Ignore
    @Test
    public void findallAddressForClientPerson() throws NoQueryPossibleException{
        ArrayList<Address> aList = new ArrayList<>();
        Address a = new Address();
        Address b = new Address();
        aList.add(a);
        aList.add(b);
        Person personA = new Person("Kobe", "name", 1, aList);
        when(addressRepository.findById(1)).thenReturn(a, b);
        List<Address> result = addressService.findAllAddressForClientPerson(1);
        
        assertEquals(aList, result);
    }
    
}
