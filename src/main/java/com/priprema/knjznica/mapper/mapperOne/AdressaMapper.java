package com.priprema.knjznica.mapper.mapperOne;

import com.priprema.knjznica.model.modelOneToOne.Adresa;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.AdresaCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.AdresaDto;
import org.springframework.stereotype.Component;

@Component
public class AdressaMapper {


    // Entitet -> DTO za prikaz
    public AdresaDto toDto(Adresa adresa) {
        AdresaDto dto = new AdresaDto();
        dto.setId(adresa.getId());
        dto.setBroj(adresa.getBroj());
        dto.setGrad(adresa.getGrad());
        dto.setUlica(adresa.getUlica());
        dto.setPostanskiBroj(adresa.getPostanskiBroj());
        return dto;
    }


    // DTO za kreiranje -> Entitet
    public Adresa toModel(AdresaCreateDto createDto) {
        Adresa adresa = new Adresa();
        adresa.setBroj(createDto.getBroj());
        adresa.setGrad(createDto.getGrad());
        adresa.setUlica(createDto.getUlica());
        adresa.setPostanskiBroj(createDto.getPostanskiBroj());
        return adresa;
    }

    // Update entiteta iz CreateDTO
    public void updateModel(Adresa existing, AdresaCreateDto createDto) {
        existing.setBroj(createDto.getBroj());
        existing.setGrad(createDto.getGrad());
        existing.setUlica(createDto.getUlica());
        existing.setPostanskiBroj(createDto.getPostanskiBroj());
    }

}
