package com.priprema.knjznica.serviceImpl.service;

import com.priprema.knjznica.model.dto.knjiga.KnjigaCreateDto;
import com.priprema.knjznica.model.dto.knjiga.KnjigaDto;
import jakarta.validation.Valid;

import java.util.List;

public interface KnjigaService {
    List<KnjigaDto> findAll();

    KnjigaDto findById(Long id);

    KnjigaDto create(@Valid KnjigaCreateDto createDto);

    KnjigaDto update(@Valid KnjigaCreateDto createDto, Long id);

    void delete(Long id);
}
