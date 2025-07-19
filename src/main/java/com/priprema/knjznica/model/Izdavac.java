package com.priprema.knjznica.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Izdavac")
public class Izdavac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv", unique = true)
    private String naziv;

    @Column(name = "autor")
    private String autor;

    //jedan izdavac moze imati vise knjiga
    @OneToMany(mappedBy = "izdavac")
    private List<Knjiga> knjiga;
}
