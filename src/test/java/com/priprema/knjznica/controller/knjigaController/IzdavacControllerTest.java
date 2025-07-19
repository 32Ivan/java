package com.priprema.knjznica.controller.knjigaController;


import com.priprema.knjznica.model.dto.izdavac.IzdavacCreateDto;
import com.priprema.knjznica.model.dto.izdavac.IzdavacDto;
import com.priprema.knjznica.serviceImpl.service.IzdavacService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class IzdavacControllerTest {

    @Mock
    private IzdavacService izdavacService;

    @InjectMocks
    private IzdavacController izdavacController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getIzdavacById() {
        Long id = 1L;
        IzdavacDto izdavac = new IzdavacDto();
        izdavac.setId(id);
        when(izdavacService.findById(id)).thenReturn(izdavac);

        ResponseEntity<IzdavacDto> response = izdavacController.findById(id);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    void getAllIzdavace() {
        List<IzdavacDto> izdavaci = Arrays.asList(new IzdavacDto(), new IzdavacDto());
        when(izdavacService.findAll()).thenReturn(izdavaci);

        ResponseEntity<List<IzdavacDto>> response = izdavacController.findAll();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void createIzdavac() {
        IzdavacCreateDto dto = new IzdavacCreateDto();
        IzdavacDto izdavac = new IzdavacDto();
        when(izdavacService.create(dto)).thenReturn(izdavac);

        ResponseEntity<IzdavacDto> response = izdavacController.create(dto);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(izdavac, response.getBody());
    }

    @Test
    void deleteIzdavac() {
        Long id = 1L;
        doNothing().when(izdavacService).delete(id);

        ResponseEntity<Void> response = izdavacController.delete(id);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(izdavacService, times(1)).delete(id);
    }

}