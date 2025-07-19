package com.priprema.knjznica.repository.izdavacRepository;

import com.priprema.knjznica.model.Izdavac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IzdavacRepository extends JpaRepository<Izdavac, Long> {
}
