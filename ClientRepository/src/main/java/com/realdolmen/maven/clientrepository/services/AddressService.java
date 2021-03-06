package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Address;
import com.realdolmen.maven.clientrepository.domain.Klant;
import com.realdolmen.maven.clientrepository.domain.Person;

import com.realdolmen.maven.clientrepository.domain.PostalCode;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.AddressRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDOAX36
 */
public class AddressService {

    private AddressRepository addressRepository;
    private PersonService personService;
    private PostalCodeService postalService;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findAddressById(int id) throws NoQueryPossibleException {
        return addressRepository.findById(id);
    }

    public List<Address> findAllAddress() throws NoQueryPossibleException {
        return addressRepository.findAll();
    }

    public List<Address> findAllAddressForClientPerson(int id) throws NoQueryPossibleException {
//        Address a = new Address();
//        if (a.getKlant() instanceof Person) {
//            return addressRepository.findAll();
//        }
        return null;
    }

    /*
     public PostalCode getPostalCode(int PostalCode) throws NoQueryPossibleException{
         return postalCodeService.getPostalCode(postalCode);
     }*/
    //Insert Address
    //Insert Address(Address address)
    //Address -> addressRepository.findbyId
    //adress.getPostalCode.getPostalCode();
    //postalService.findById(adress.getPostalCode.getPostalCode()
    //address.setPostalCode(postalCode
    //return adress
    //findAddressById
    //adress.getPostalCode
    //findAllAddressForClientPerson(int id)
    //zoek een adres die van een bepaald persoon
    //findAllAddressFromClientFirm(int id)
}
