package com.priprema.knjznica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Knjiga")
public class Knjiga {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv", unique = true)
    private String naziv;

    @Column(name = "autor")
    private String autor;

    @Column(name = "zanr")
    private String zanr;

    @Column(name = "brojStrana")
    private Integer brojStrana;

    @Column(name = "isbn", unique = true)
    private Integer isbn;

    @Column(name = "dostupna")
    private boolean je_dostupna;

    //svaka knjiga mora imati jednog izdavaca
    @ManyToOne
    @JoinColumn(name = "izdavac_id", nullable = false)
    private Izdavac izdavac;


}
