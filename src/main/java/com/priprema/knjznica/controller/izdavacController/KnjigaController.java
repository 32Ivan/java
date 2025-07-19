package com.priprema.knjznica.controller.izdavacController;

import com.priprema.knjznica.model.dto.knjiga.KnjigaCreateDto;
import com.priprema.knjznica.model.dto.knjiga.KnjigaDto;
import com.priprema.knjznica.serviceImpl.service.KnjigaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/knjige")
@RequiredArgsConstructor
public class KnjigaController {

    private final KnjigaService knjigaService;

    @GetMapping()
    public ResponseEntity<List<KnjigaDto>> findAll() {
        List<KnjigaDto> knjigaDto = knjigaService.findAll();
        return ResponseEntity.ok(knjigaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KnjigaDto> findById(@PathVariable Long id) {
        KnjigaDto knjigaDto = knjigaService.findById(id);
        return ResponseEntity.ok(knjigaDto);
    }

    @PostMapping()
    public ResponseEntity<KnjigaDto> create(@RequestBody @Valid KnjigaCreateDto createDto) {
        KnjigaDto knjigaDto = knjigaService.create(createDto);
        return ResponseEntity.status(201).body(knjigaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KnjigaDto> update(@RequestBody @Valid KnjigaCreateDto createDto, @PathVariable Long id) {
        KnjigaDto knjigaDto = knjigaService.update(createDto, id);
        return ResponseEntity.ok(knjigaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        knjigaService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
