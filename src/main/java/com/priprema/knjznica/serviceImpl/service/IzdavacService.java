package com.priprema.knjznica.serviceImpl.service;

import com.priprema.knjznica.model.dto.izdavac.IzdavacCreateDto;
import com.priprema.knjznica.model.dto.izdavac.IzdavacDto;
import jakarta.validation.Valid;

import java.util.List;

public interface IzdavacService {
    List<IzdavacDto> findAll();

    IzdavacDto findById(Long id);

    IzdavacDto create(@Valid IzdavacCreateDto createDto);

    IzdavacDto update(@Valid IzdavacCreateDto createDto, Long id);

    void delete(Long id);

}
