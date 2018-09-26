/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.PostalCode;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.realdolmen.maven.clientrepository.repositories.PostalCodeRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

/**
 * @author SDOAX36
 */
@RunWith(MockitoJUnitRunner.class)
public class PostalCodeServiceTest {

    PostalCodeService postalCodeService;

    @Mock
    private PostalCodeRepository postalCodeRepository;

    @Before
    public void init() {
        postalCodeService = new PostalCodeService(postalCodeRepository);
    }


    @Test
    public void FindAllPostalCodesTestSuccess() throws Exception {
        List<PostalCode> postalCodes = new ArrayList<>();
        when(postalCodeRepository.findAll()).thenReturn(postalCodes);
        List<PostalCode> result = postalCodeService.findAllPostalCodes();
        assertEquals(postalCodes, result);
        verify(postalCodeRepository, times(1)).findAll();
    }


    private void createPostals(List<PostalCode> listToFill) {
        for (int i = 7; i <= 10; i++) {
            PostalCode postalCode = new PostalCode();
            postalCode.setNumber(i * 1000);
            listToFill.add(postalCode);
        }
    }

    @Test
    public void testFindAllPostalCodesFromTheNine() throws Exception {

        List<PostalCode> postalCodes = new ArrayList<>();
        createPostals(postalCodes);
        when(postalCodeRepository.findAll()).thenReturn(postalCodes);
        List<PostalCode> result = postalCodeService.findAllPostalCodesFromTheNine();
        assertNotEquals(postalCodes, result);
        assertEquals(1, result.size());
        assertEquals(9000, result.get(0).getNumber());
        verify(postalCodeRepository, times(1)).findAll();
    }


    @Test
    public void testFindById() throws Exception {
        PostalCode postalCode = new PostalCode();
        when(postalCodeRepository.findById(1)).thenReturn(postalCode);
        PostalCode result = postalCodeService.findById(1);
        assertEquals(postalCode, result);
        verify(postalCodeRepository, times(1)).findById(1);

    }

    @Test
    public void testRemovePostalCode() throws NoQueryPossibleException {
        PostalCode postalCode = new PostalCode();
        postalCode.setNumber(1000);
        postalCodeService.removePostalCode(postalCode);
        verify(postalCodeRepository, times(1)).deleteItem(postalCode.getNumber());
    }

    @Test
    public void testUpdatePostalCode() {
    }

    @Test
    public void insertPostalCodeTest() throws Exception {
        PostalCode postalCode = new PostalCode();
        postalCode.setNumber(1);
        when(postalCodeRepository.insertItem(postalCode)).thenReturn(1);
        when(postalCodeRepository.findById(1)).thenReturn(postalCode);
        PostalCode result = postalCodeService.insertPostalCode(postalCode);
        assertEquals(result, postalCode);
        verify(postalCodeRepository, times(1)).insertItem(postalCode);
    }
}


