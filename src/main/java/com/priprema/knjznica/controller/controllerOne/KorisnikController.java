package com.priprema.knjznica.controller.controllerOne;

import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikCreateDto;
import com.priprema.knjznica.model.modelOneToOne.dtoOne.KorisnikDto;
import com.priprema.knjznica.serviceImpl.serviceOne.serviceImpl.KorisnikServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/korisnici")
@RequiredArgsConstructor
public class KorisnikController {

    private final KorisnikServiceImpl korisnikService;

    @GetMapping()
    public ResponseEntity<List<KorisnikDto>> findAll() {
        List<KorisnikDto> korisnikDto = korisnikService.findAll();
        return ResponseEntity.ok(korisnikDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KorisnikDto> findById(@PathVariable Long id) {
        KorisnikDto korisnikDto = korisnikService.findById(id);
        return ResponseEntity.ok(korisnikDto);
    }

    @PostMapping()
    public ResponseEntity<KorisnikDto> create(@RequestBody @Valid KorisnikCreateDto createDto) {
        KorisnikDto korisnikDto = korisnikService.create(createDto);
        return ResponseEntity.status(201).body(korisnikDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KorisnikDto> update(@RequestBody @Valid KorisnikCreateDto createDto, @PathVariable Long id) {
        KorisnikDto korisnikDto = korisnikService.update(createDto, id);
        return ResponseEntity.ok(korisnikDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        korisnikService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
