package com.realdolmen.maven.clientrepository.repositories;

import com.realdolmen.maven.clientrepository.domain.Firm;
import com.realdolmen.maven.clientrepository.exceptions.NoQueryPossibleException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
    public class FirmRepositoryTest{
   
    private FirmRepository firmRepository;
    
    
    @Mock
    private ResultSet resultSet;
    
    @Before
    public void init(){
        firmRepository = new FirmRepository(AbstractRepositoryTest.URL);
    }
    
    @Test
    public void findAllTestResultNotEmpty() throws NoQueryPossibleException{
        firmRepository =  new FirmRepository();
        assertFalse(firmRepository.findAll().isEmpty());
    }
    
    @Test
    public void deleteItemTest() throws NoQueryPossibleException{
        firmRepository = new FirmRepository();
        firmRepository.deleteItem(1);
        List<Firm> firms = firmRepository.findAll();
        for(Firm f : firms){
            assertNotEquals(f.getNumber(),1);
        }
    }
        
         @Test
        public void createObjectFirmTestSuccess() throws SQLException {
        //initialiseren data
        when(resultSet.getInt(FirmRepository.KEY))
                .thenReturn(1);
        when(resultSet.getString(FirmRepository.NAME))
                .thenReturn("real dolmen");
        when(resultSet.getString(FirmRepository.TAX_ID))
                .thenReturn("123");
        when(resultSet.getString(FirmRepository.FIELD))
                .thenReturn("IT");
        Firm result = firmRepository.createObject(resultSet);
        //verify the result
        assertEquals(1,result.getNumber());
        assertEquals("real dolmen", result.getName());
        assertEquals("123", result.getTaxNumber());
        assertEquals("IT", result.getField());
        
        verify(resultSet,times(1)).getInt(FirmRepository.KEY);
        verify(resultSet,times(1)).getString(FirmRepository.NAME);
        verify(resultSet,times(1)).getString(FirmRepository.TAX_ID);
        verify(resultSet,times(1)).getString(FirmRepository.FIELD);
    }
    
       @Test
        public void createObjectTestThrowsSQLException() throws SQLException{
        when(resultSet.getInt(PersonRepository.KEY)).thenThrow(SQLException.class);
        
        //test the object
        Firm result = firmRepository.createObject(resultSet);
        
        verify(resultSet,times(1)).getInt(FirmRepository.KEY);
        verifyNoMoreInteractions(resultSet);
    }
    }

    
//    private void insertFirm(){
//        Firm firm = new Firm();
//        firm.setNumber(100);
//        firm.setName("nv to remove");
//        firmRepository.insertItem(firm);
//    }
//    

