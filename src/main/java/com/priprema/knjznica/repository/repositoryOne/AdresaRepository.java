package com.priprema.knjznica.repository.repositoryOne;

import com.priprema.knjznica.model.modelOneToOne.Adresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long> {
}
