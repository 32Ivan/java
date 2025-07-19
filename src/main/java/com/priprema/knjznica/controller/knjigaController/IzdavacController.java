package com.priprema.knjznica.controller.knjigaController;

import com.priprema.knjznica.model.dto.izdavac.IzdavacCreateDto;
import com.priprema.knjznica.model.dto.izdavac.IzdavacDto;
import com.priprema.knjznica.serviceImpl.service.IzdavacService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/izdavaci")
public class IzdavacController {

    private final IzdavacService izdavacService;

    @GetMapping()
    public ResponseEntity<List<IzdavacDto>> findAll() {
        List<IzdavacDto> izdavacDto = izdavacService.findAll();
        return ResponseEntity.ok(izdavacDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IzdavacDto> findById(@PathVariable Long id) {
        IzdavacDto izdavacDto = izdavacService.findById(id);
        return ResponseEntity.ok(izdavacDto);
    }

    @PostMapping()
    public ResponseEntity<IzdavacDto> create(@RequestBody @Valid IzdavacCreateDto createDto) {
        IzdavacDto izdavacDto = izdavacService.create(createDto);
        return ResponseEntity.status(201).body(izdavacDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IzdavacDto> update(@RequestBody @Valid IzdavacCreateDto createDto, @PathVariable Long id) {
        IzdavacDto izdavacDto = izdavacService.update(createDto, id);
        return ResponseEntity.ok(izdavacDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        izdavacService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
