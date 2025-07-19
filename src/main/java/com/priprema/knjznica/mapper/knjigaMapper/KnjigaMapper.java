package com.priprema.knjznica.mapper.knjigaMapper;

import com.priprema.knjznica.mapper.izdavacMapper.IzdavacMapper;
import com.priprema.knjznica.model.Knjiga;
import com.priprema.knjznica.model.dto.knjiga.KnjigaCreateDto;
import com.priprema.knjznica.model.dto.knjiga.KnjigaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KnjigaMapper {

    private final IzdavacMapper izdavacMapper;
    
    public KnjigaDto toDto(Knjiga knjiga) {
        KnjigaDto dto = new KnjigaDto();
        dto.setId(knjiga.getId());
        dto.setNaziv(knjiga.getNaziv());
        dto.setAutor(knjiga.getAutor());
        dto.setZanr(knjiga.getZanr());
        dto.setBrojStrana(knjiga.getBrojStrana());
        dto.setIsbn(knjiga.getIsbn());
        dto.setJe_dostupna(knjiga.isJe_dostupna());

        if (knjiga.getIzdavac() != null) {
            dto.setIzdavac(izdavacMapper.toDto(knjiga.getIzdavac()));
        }
        return dto;

    }

    public Knjiga toModel(KnjigaDto dto) {
        Knjiga knjiga = new Knjiga();
        knjiga.setId(dto.getId());
        knjiga.setNaziv(dto.getNaziv());
        knjiga.setAutor(dto.getAutor());
        knjiga.setZanr(dto.getZanr());
        knjiga.setBrojStrana(dto.getBrojStrana());
        knjiga.setIsbn(dto.getIsbn());
        knjiga.setJe_dostupna(dto.isJe_dostupna());
        return knjiga;

    }

    public KnjigaDto createToDto(KnjigaCreateDto knjiga) {
        return toDto(createToModel(knjiga));
    }

    public void updateModel(Knjiga existing, KnjigaCreateDto dto) {
        existing.setNaziv(dto.getNaziv());
        existing.setAutor(dto.getAutor());
        existing.setZanr(dto.getZanr());
        existing.setBrojStrana(dto.getBrojStrana());
        existing.setIsbn(dto.getIsbn());
        existing.setJe_dostupna(dto.isJe_dostupna());
    }

    public Knjiga createToModel(KnjigaCreateDto knjiga) {
        Knjiga model = new Knjiga();
        model.setNaziv(knjiga.getNaziv());
        model.setAutor(knjiga.getAutor());
        model.setZanr(knjiga.getZanr());
        model.setBrojStrana(knjiga.getBrojStrana());
        model.setIsbn(knjiga.getIsbn());
        model.setJe_dostupna(knjiga.isJe_dostupna());
        return model;

    }

}
