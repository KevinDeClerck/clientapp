package com.realdolmen.maven.clientrepository.services;

import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import com.realdolmen.maven.clientrepository.repositories.FirmRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Ignore;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FirmServiceTest {

    private FirmService firmService;

    @Mock
    private FirmRepository firmRepository;
    
    @Before
    public void init() {
        firmService = new FirmService(firmRepository);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Firm> firms = new ArrayList<>();
        when(firmRepository.findAll()).thenReturn(firms);
        List<Firm> result = firmService.findAll();
        assertEquals(result, firms);
        verify(firmRepository,times(1)).findAll();
    }

   @Test
    public void findByIDFirmTestSuccess() throws NoQueryPossibleException{
        Firm firm = new Firm();
        when(firmRepository.findById(1)).thenReturn(firm);
        Firm result = firmService.findById(1);
        assertEquals(firm, result);
        verify(firmRepository,times(1)).findById(1);
        
        
    }
    
    @Test
    public void insertFirmTestSuccess() throws Exception {
        Firm firm = new Firm();
        firm.setNumber(1);
      when(firmRepository.insertItem(firm)).thenReturn(1);
      when(firmRepository.findById(1)).thenReturn(firm);
      Firm result = firmService.insertFirm(firm);  
      assertEquals(result, firm);
      verify(firmRepository, times(1)).insertItem(firm);
    }

    @Test
    public void testRemovePerson() throws NoQueryPossibleException {
        Firm firm = new Firm();
        firm.setNumber(1);
        firmService.removeFirm(firm);
        verify(firmRepository, times(1)).deleteItem(firm.getNumber());
    }
}
