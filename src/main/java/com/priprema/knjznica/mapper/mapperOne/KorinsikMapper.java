package com.priprema.knjznica.mapper.mapperOne;

import com.priprema.knjznica.model.modelOneToOne.Korisnik;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KorinsikMapper {

    private final AdressaMapper adressaMapper;

    // Entitet -> DTO za prikaz
    public KorisnikDto toDto(Korisnik korisnik) {
        KorisnikDto dto = new KorisnikDto();
        dto.setId(korisnik.getId());
        dto.setIme(korisnik.getIme());
        dto.setPrezime(korisnik.getPrezime());
        dto.setLozinka(korisnik.getLozinka());
        dto.setEmail(korisnik.getEmail());

        if (korisnik.getAdresa() != null) {
            dto.setAdresa(adressaMapper.toDto(korisnik.getAdresa()));
        }

        return dto;
    }


    // DTO za kreiranje -> Entitet
    public Korisnik toModel(KorisnikCreateDto createDto) {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(createDto.getIme());
        korisnik.setPrezime(createDto.getPrezime());
        korisnik.setLozinka(createDto.getLozinka());
        korisnik.setEmail(createDto.getEmail());
        return korisnik;
    }

    // Update entiteta iz CreateDTO
    public void updateModel(Korisnik existing, KorisnikCreateDto createDto) {
        existing.setIme(createDto.getIme());
        existing.setPrezime(createDto.getPrezime());
        existing.setEmail(createDto.getEmail());
        existing.setLozinka(createDto.getLozinka());

    }
}
