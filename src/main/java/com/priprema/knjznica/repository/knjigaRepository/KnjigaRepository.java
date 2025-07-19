package com.priprema.knjznica.repository.knjigaRepository;

import com.priprema.knjznica.model.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
}
