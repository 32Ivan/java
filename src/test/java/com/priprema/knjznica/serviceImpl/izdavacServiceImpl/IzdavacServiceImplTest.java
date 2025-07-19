package com.priprema.knjznica.serviceImpl.izdavacServiceImpl;

import com.priprema.knjznica.mapper.izdavacMapper.IzdavacMapper;
import com.priprema.knjznica.model.Izdavac;
import com.priprema.knjznica.model.dto.izdavac.IzdavacCreateDto;
import com.priprema.knjznica.model.dto.izdavac.IzdavacDto;
import com.priprema.knjznica.repository.izdavacRepository.IzdavacRepository;
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
import static org.mockito.Mockito.*;

class IzdavacServiceImplTest {


    @Mock
    private IzdavacRepository izdavacRepository;

    @Mock
    private IzdavacMapper izdavacMapper;

    @InjectMocks
    private IzdavacServiceImpl izdavacService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Izdavac> izdavaci = Arrays.asList(new Izdavac(), new Izdavac());
        List<IzdavacDto> dtoList = Arrays.asList(new IzdavacDto(), new IzdavacDto());

        when(izdavacRepository.findAll()).thenReturn(izdavaci);
        when(izdavacMapper.toDto(any())).thenReturn(new IzdavacDto());

        List<IzdavacDto> result = izdavacService.findAll();

        assertEquals(2, result.size());
        verify(izdavacRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        Long id = 1L;
        Izdavac izdavac = new Izdavac();
        IzdavacDto dto = new IzdavacDto();

        when(izdavacRepository.findById(id)).thenReturn(Optional.of(izdavac));
        when(izdavacMapper.toDto(izdavac)).thenReturn(dto);

        IzdavacDto result = izdavacService.findById(id);

        assertNotNull(result);
        verify(izdavacRepository).findById(id);
    }

    @Test
    void testFindByIdNotFound() {
        Long id = 1L;

        when(izdavacRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> izdavacService.findById(id));
    }

    @Test
    void testCreate() {
        IzdavacCreateDto createDto = new IzdavacCreateDto();
        IzdavacDto intermediateDto = new IzdavacDto();
        Izdavac model = new Izdavac();

        when(izdavacMapper.createToDto(createDto)).thenReturn(intermediateDto);
        when(izdavacMapper.toModel(intermediateDto)).thenReturn(model);
        when(izdavacRepository.save(model)).thenReturn(model);
        when(izdavacMapper.toDto(model)).thenReturn(new IzdavacDto());

        IzdavacDto result = izdavacService.create(createDto);

        assertNotNull(result);
        verify(izdavacRepository).save(model);
    }

    @Test
    void testUpdateFound() {
        Long id = 1L;
        IzdavacCreateDto createDto = new IzdavacCreateDto();
        Izdavac existing = new Izdavac();
        Izdavac saved = new Izdavac();
        IzdavacDto dto = new IzdavacDto();

        when(izdavacRepository.findById(id)).thenReturn(Optional.of(existing));
        doNothing().when(izdavacMapper).updateModel(existing, createDto);
        when(izdavacRepository.save(existing)).thenReturn(saved);
        when(izdavacMapper.toDto(saved)).thenReturn(dto);

        IzdavacDto result = izdavacService.update(createDto, id);

        assertNotNull(result);
        verify(izdavacMapper).updateModel(existing, createDto);
        verify(izdavacRepository).save(existing);
    }

    @Test
    void testUpdateNotFound() {
        Long id = 1L;
        IzdavacCreateDto createDto = new IzdavacCreateDto();

        when(izdavacRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> izdavacService.update(createDto, id));
    }

    @Test
    void testDeleteFound() {
        Long id = 1L;
        when(izdavacRepository.findById(id)).thenReturn(Optional.of(new Izdavac()));

        izdavacService.delete(id);

        verify(izdavacRepository).deleteById(id);
    }

    @Test
    void testDeleteNotFound() {
        Long id = 1L;
        when(izdavacRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> izdavacService.delete(id));
    }

}