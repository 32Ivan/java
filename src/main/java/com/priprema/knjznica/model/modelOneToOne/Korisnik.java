package com.priprema.knjznica.model.modelOneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;

    private String prezime;

    private String email;

    private String lozinka;

    @OneToOne
    @JoinColumn(name = "adresa_id", nullable = false)
    private Adresa adresa;
}
