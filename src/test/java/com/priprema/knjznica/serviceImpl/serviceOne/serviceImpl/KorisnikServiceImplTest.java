package com.priprema.knjznica.serviceImpl.serviceOne.serviceImpl;

import com.priprema.knjznica.mapper.mapperOne.KorinsikMapper;
import com.priprema.knjznica.model.modelOneToOne.Adresa;
import com.priprema.knjznica.model.modelOneToOne.Korisnik;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikDto;
import com.priprema.knjznica.repository.repositoryOne.AdresaRepository;
import com.priprema.knjznica.repository.repositoryOne.KorisnikRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class KorisnikServiceImplTest {

    @Mock
    private KorisnikRepository korisnikRepository;

    @Mock
    private AdresaRepository adresaRepository;

    @Mock
    private KorinsikMapper korisnikMapper;

    @InjectMocks
    private KorisnikServiceImpl korisnikService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Korisnik> korisniks = Arrays.asList(new Korisnik(), new Korisnik());
        List<KorisnikDto> dtoList = Arrays.asList(new KorisnikDto(), new KorisnikDto());

        when(korisnikRepository.findAll()).thenReturn(korisniks);
        when(korisnikMapper.toDto(any())).thenReturn(new KorisnikDto());

        List<KorisnikDto> result = korisnikService.findAll();

        assertEquals(2, result.size());
        verify(korisnikRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        Long id = 1L;
        Korisnik korisnik = new Korisnik();
        KorisnikDto dto = new KorisnikDto();

        when(korisnikRepository.findById(id)).thenReturn(Optional.of(korisnik));
        when(korisnikMapper.toDto(korisnik)).thenReturn(dto);

        KorisnikDto result = korisnikService.findById(id);

        assertNotNull(result);
        verify(korisnikRepository).findById(id);
    }

    @Test
    void testFindByIdNotFound() {
        Long id = 1L;

        when(korisnikRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> korisnikService.findById(id));
    }

    @Test
    void testCreate() {
        // Arrange
        KorisnikCreateDto createDto = mock(KorisnikCreateDto.class);
        Long adresaId = 5L;

        Adresa adresa = new Adresa();
        Korisnik korisnikModel = new Korisnik();
        KorisnikDto korisnikDto = new KorisnikDto();

        when(createDto.getAdresaId()).thenReturn(adresaId);
        when(adresaRepository.findById(adresaId)).thenReturn(Optional.of(adresa));
        when(korisnikMapper.toModel(createDto)).thenReturn(korisnikModel);
        when(korisnikRepository.save(korisnikModel)).thenReturn(korisnikModel);
        when(korisnikMapper.toDto(korisnikModel)).thenReturn(korisnikDto);

        // Act
        KorisnikDto result = korisnikService.create(createDto);

        // Assert
        assertNotNull(result);
        verify(korisnikRepository).save(korisnikModel);
        verify(korisnikMapper).toDto(korisnikModel);
    }

    @Test
    void testUpdateFound() {
        Long id = 1L;
        KorisnikCreateDto createDto = new KorisnikCreateDto();
        Korisnik existing = new Korisnik();
        Korisnik saved = new Korisnik();
        KorisnikDto dto = new KorisnikDto();

        when(korisnikRepository.findById(id)).thenReturn(Optional.of(existing));
        doNothing().when(korisnikMapper).updateModel(existing, createDto);
        when(korisnikRepository.save(existing)).thenReturn(saved);
        when(korisnikMapper.toDto(saved)).thenReturn(dto);

        KorisnikDto result = korisnikService.update(createDto, id);

        assertNotNull(result);
        verify(korisnikMapper).updateModel(existing, createDto);
        verify(korisnikRepository).save(existing);
    }

    @Test
    void testUpdateNotFound() {
        Long id = 1L;
        KorisnikCreateDto createDto = new KorisnikCreateDto();

        when(korisnikRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> korisnikService.update(createDto, id));
    }


    @Test
    void testDeleteNotFound() {
        Long id = 1L;
        when(korisnikRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> korisnikService.delete(id));
    }

}