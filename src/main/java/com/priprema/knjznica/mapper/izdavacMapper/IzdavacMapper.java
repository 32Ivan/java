package com.priprema.knjznica.mapper.izdavacMapper;

import com.priprema.knjznica.model.Izdavac;
import com.priprema.knjznica.model.dto.izdavac.IzdavacCreateDto;
import com.priprema.knjznica.model.dto.izdavac.IzdavacDto;
import org.springframework.stereotype.Component;

@Component
public class IzdavacMapper {

    public IzdavacDto toDto(Izdavac izdavac) {
        IzdavacDto dto = new IzdavacDto();
        dto.setId(izdavac.getId());
        dto.setNaziv(izdavac.getNaziv());
        dto.setAutor(izdavac.getAutor());
        return dto;

    }

    public Izdavac toModel(IzdavacDto dto) {
        Izdavac izdavac = new Izdavac();
        izdavac.setId(dto.getId());
        izdavac.setNaziv(dto.getNaziv());
        izdavac.setAutor(dto.getAutor());
        return izdavac;

    }

    public IzdavacDto createToDto(IzdavacCreateDto izdavac) {
        return toDto(createToModel(izdavac));
    }

    public void updateModel(Izdavac existing, IzdavacCreateDto dto) {
        existing.setNaziv(dto.getNaziv());
        existing.setAutor(dto.getAutor());
    }

    public Izdavac createToModel(IzdavacCreateDto izdavac) {
        Izdavac model = new Izdavac();
        model.setNaziv(izdavac.getNaziv());
        model.setAutor(izdavac.getAutor());
        return model;

    }
}
