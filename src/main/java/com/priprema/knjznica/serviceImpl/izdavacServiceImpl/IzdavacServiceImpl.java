package com.priprema.knjznica.serviceImpl.izdavacServiceImpl;

import com.priprema.knjznica.mapper.izdavacMapper.IzdavacMapper;
import com.priprema.knjznica.model.Izdavac;
import com.priprema.knjznica.model.dto.izdavac.IzdavacCreateDto;
import com.priprema.knjznica.model.dto.izdavac.IzdavacDto;
import com.priprema.knjznica.repository.izdavacRepository.IzdavacRepository;
import com.priprema.knjznica.serviceImpl.service.IzdavacService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IzdavacServiceImpl implements IzdavacService {

    private final IzdavacRepository izdavacRepository;
    private final IzdavacMapper izdavacMapper;


    @Override
    public List<IzdavacDto> findAll() {
        List<Izdavac> izdavac = izdavacRepository.findAll();
        return izdavac.stream().map(izdavacMapper::toDto).toList();

    }

    @Transactional
    @Override
    public IzdavacDto findById(Long id) {

        return izdavacMapper.toDto(izdavacRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "izdavac sa tim id nije pronadena")));

    }

    @Transactional
    @Override
    public IzdavacDto create(IzdavacCreateDto createDto) {

        IzdavacDto dto = izdavacMapper.createToDto(createDto);

        Izdavac izdavac = izdavacRepository.save(izdavacMapper.toModel(dto));

        return izdavacMapper.toDto(izdavac);

    }

    @Transactional
    @Override
    public IzdavacDto update(IzdavacCreateDto createDto, Long id) {
        Izdavac izdavac = izdavacRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "izdavac sa tim id nije pronadena"));

        izdavacMapper.updateModel(izdavac, createDto);

        return izdavacMapper.toDto(izdavacRepository.save(izdavac));
    }

    @Override
    public void delete(Long id) {
        if (!izdavacRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "izdavac sa tim id nije pronadena");
        }
        izdavacRepository.deleteById(id);
    }

}
