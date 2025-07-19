package com.priprema.knjznica.repository.repositoryOne;

import com.priprema.knjznica.model.modelOneToOne.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
}
