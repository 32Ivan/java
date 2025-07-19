package com.priprema.knjznica.serviceImpl.serviceOne.serviceImpl;

import com.priprema.knjznica.mapper.mapperOne.AdressaMapper;
import com.priprema.knjznica.model.modelOneToOne.Adresa;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.AdresaCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.AdresaDto;
import com.priprema.knjznica.repository.repositoryOne.AdresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdresaServiceImpl {

    private final AdresaRepository adresaRepository;

    private final AdressaMapper adressaMapper;


    public List<AdresaDto> findAll() {
        List<Adresa> adresas = adresaRepository.findAll();
        return adresas.stream().map(adressaMapper::toDto).toList();

    }

    public AdresaDto findById(Long id) {

        return adressaMapper.toDto(adresaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Adresa sa tim id nije pronadena")));

    }

    @Transactional
    public AdresaDto create(AdresaCreateDto createDto) {

        Adresa adresa = adresaRepository.save(adressaMapper.toModel(createDto));

        return adressaMapper.toDto(adresa);

    }

    @Transactional
    public AdresaDto update(AdresaCreateDto adresaCreateDto, Long id) {
        Adresa adresa = adresaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "adresa sa tim id nije pronadena"));

        adressaMapper.updateModel(adresa, adresaCreateDto);

        return adressaMapper.toDto(adresaRepository.save(adresa));
    }

    @Transactional
    public void delete(Long id) {
        if (!adresaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adresa sa tim id nije pronadena");
        }
        adresaRepository.deleteById(id);
    }

}
