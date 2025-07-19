package com.priprema.knjznica.controller.controllerOne;

import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikDto;
import com.priprema.knjznica.serviceImpl.serviceOne.serviceImpl.KorisnikServiceImpl;
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

class KorisnikControllerTest {

    @Mock
    private KorisnikServiceImpl korisnikService;

    @InjectMocks
    private KorisnikController korisnikController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getIzdavacById() {
        Long id = 1L;
        KorisnikDto korisnikDto = new KorisnikDto();
        korisnikDto.setId(id);
        when(korisnikService.findById(id)).thenReturn(korisnikDto);

        ResponseEntity<KorisnikDto> response = korisnikController.findById(id);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    void getAllIzdavace() {
        List<KorisnikDto> izdavaci = Arrays.asList(new KorisnikDto(), new KorisnikDto());
        when(korisnikService.findAll()).thenReturn(izdavaci);

        ResponseEntity<List<KorisnikDto>> response = korisnikController.findAll();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void createIzdavac() {
        KorisnikCreateDto dto = new KorisnikCreateDto();
        KorisnikDto korisnikDto = new KorisnikDto();
        when(korisnikService.create(dto)).thenReturn(korisnikDto);

        ResponseEntity<KorisnikDto> response = korisnikController.create(dto);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(korisnikDto, response.getBody());
    }

    @Test
    void deleteIzdavac() {
        Long id = 1L;
        doNothing().when(korisnikService).delete(id);

        ResponseEntity<Void> response = korisnikController.delete(id);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(korisnikService, times(1)).delete(id);
    }


}