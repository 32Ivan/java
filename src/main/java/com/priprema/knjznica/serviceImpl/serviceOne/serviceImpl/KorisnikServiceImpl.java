package com.priprema.knjznica.serviceImpl.serviceOne.serviceImpl;

import com.priprema.knjznica.mapper.mapperOne.KorinsikMapper;
import com.priprema.knjznica.model.modelOneToOne.Adresa;
import com.priprema.knjznica.model.modelOneToOne.Korisnik;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikDto;
import com.priprema.knjznica.repository.repositoryOne.AdresaRepository;
import com.priprema.knjznica.repository.repositoryOne.KorisnikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KorisnikServiceImpl {

    private final KorisnikRepository korisnikRepository;
    private final AdresaRepository adresaRepository;

    private final KorinsikMapper korinsikMapper;


    public List<KorisnikDto> findAll() {
        List<Korisnik> korisniks = korisnikRepository.findAll();
        return korisniks.stream().map(korinsikMapper::toDto).toList();

    }

    public KorisnikDto findById(Long id) {

        return korinsikMapper.toDto(korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik sa tim id nije pronadena")));

    }

    @Transactional
    public KorisnikDto create(KorisnikCreateDto createDto) {
        Adresa adresa = adresaRepository.findById(createDto.getAdresaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Adresa sa tim id nije pronadena"));
        Korisnik korisnik = korinsikMapper.toModel(createDto);
        korisnik.setAdresa(adresa);
        Korisnik saved = korisnikRepository.save(korisnik);
        return korinsikMapper.toDto(saved);


    }

    @Transactional
    public KorisnikDto update(KorisnikCreateDto createDto, Long id) {
        Korisnik korisnik = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Adresa sa tim id nije pronadena"));
        korinsikMapper.updateModel(korisnik, createDto);

        return korinsikMapper.toDto(korisnikRepository.save(korisnik));
    }

    @Transactional
    public void delete(Long id) {
        if (!korisnikRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik sa tim id nije pronadena");
        }
        korisnikRepository.deleteById(id);
    }

}
