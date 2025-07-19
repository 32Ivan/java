package com.priprema.knjznica.controller.controllerOne;

import com.priprema.knjznica.model.modelOneToOne.dtoOne.AdresaCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.AdresaDto;
import com.priprema.knjznica.serviceImpl.serviceOne.serviceImpl.AdresaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adrese")
@RequiredArgsConstructor
public class AdresaController {

    private final AdresaServiceImpl adresaService;

    @GetMapping()
    public ResponseEntity<List<AdresaDto>> findAll() {
        List<AdresaDto> adresaDtos = adresaService.findAll();
        return ResponseEntity.ok(adresaDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdresaDto> findById(@PathVariable Long id) {
        AdresaDto adresaDto = adresaService.findById(id);
        return ResponseEntity.ok(adresaDto);
    }

    @PostMapping()
    public ResponseEntity<AdresaDto> create(@RequestBody @Valid AdresaCreateDto createDto) {
        AdresaDto adresaDto = adresaService.create(createDto);
        return ResponseEntity.status(201).body(adresaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdresaDto> update(@RequestBody @Valid AdresaCreateDto createDto, @PathVariable Long id) {
        AdresaDto adresaDto = adresaService.update(createDto, id);
        return ResponseEntity.ok(adresaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        adresaService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
