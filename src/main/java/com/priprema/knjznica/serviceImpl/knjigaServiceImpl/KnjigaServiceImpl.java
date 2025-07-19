package com.priprema.knjznica.serviceImpl.knjigaServiceImpl;

import com.priprema.knjznica.mapper.knjigaMapper.KnjigaMapper;
import com.priprema.knjznica.model.Izdavac;
import com.priprema.knjznica.model.Knjiga;
import com.priprema.knjznica.model.dto.knjiga.KnjigaCreateDto;
import com.priprema.knjznica.model.dto.knjiga.KnjigaDto;
import com.priprema.knjznica.repository.izdavacRepository.IzdavacRepository;
import com.priprema.knjznica.repository.knjigaRepository.KnjigaRepository;
import com.priprema.knjznica.serviceImpl.service.KnjigaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KnjigaServiceImpl implements KnjigaService {

    private final KnjigaRepository knjigaRepository;
    private final IzdavacRepository izdavacRepository;
    private final KnjigaMapper knjigaMapper;


    @Override
    public List<KnjigaDto> findAll() {
        List<Knjiga> knjigae = knjigaRepository.findAll();
        return knjigae.stream().map(knjigaMapper::toDto).toList();

    }

    @Override
    public KnjigaDto findById(Long id) {

        return knjigaMapper.toDto(knjigaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Knjiga sa tim id nije pronadena")));

    }

    @Transactional
    @Override
    public KnjigaDto create(KnjigaCreateDto createDto) {
        Izdavac izdavac = izdavacRepository.findById(createDto.getIzdavacId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Izdavac sa tim id nije pronadena"));
        Knjiga knjiga = knjigaMapper.createToModel(createDto);
        knjiga.setIzdavac(izdavac);
        Knjiga saved = knjigaRepository.save(knjiga);
        return knjigaMapper.toDto(saved);

    }

    @Transactional
    @Override
    public KnjigaDto update(KnjigaCreateDto createDto, Long id) {
        Izdavac izdavac = izdavacRepository.findById(createDto.getIzdavacId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Izdavac sa tim id nije pronadena"));

        Knjiga knjiga = knjigaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Knjiga sa tim id nije pronadena"));
        knjiga.setIzdavac(izdavac);
        knjigaMapper.updateModel(knjiga, createDto);

        return knjigaMapper.toDto(knjigaRepository.save(knjiga));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if (!knjigaRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Knjiga sa tim id nije pronadena");
        }
        knjigaRepository.deleteById(id);
    }

}
