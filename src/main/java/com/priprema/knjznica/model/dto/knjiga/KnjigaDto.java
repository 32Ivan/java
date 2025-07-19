package com.priprema.knjznica.model.dto.knjiga;

import com.priprema.knjznica.model.dto.izdavac.IzdavacDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KnjigaDto {

    private Long id;

    @NotBlank(message = "Knjiga mora imati naziv")
    @Size(min = 3, max = 20)
    private String naziv;

    @NotBlank(message = "Knjiga mora imati autora")
    @Size(min = 3, max = 20)
    private String autor;

    @NotBlank(message = "Knjiga mora imati zanr")
    @Size(min = 3, max = 20)
    private String zanr;

    @NotNull(message = "Knjiga mora imati broj stranica")
    private Integer brojStrana;

    @NotNull(message = "Knjiga mora imati broj isbn")
    private Integer isbn;

    @NotNull(message = "Knjiga mora imati dostupnost")
    private boolean je_dostupna;
    
    private IzdavacDto izdavac;

}
