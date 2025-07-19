package com.priprema.knjznica.model.modelOneToOne.dtoOne;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KorisnikCreateDto {

    @NotBlank(message = "Korisnik mora imati ime")
    @Size(min = 3, max = 20)
    private String ime;

    @NotBlank(message = "Korisnik mora imati prezime")
    @Size(min = 3, max = 20)
    private String prezime;

    @NotBlank(message = "Korisnik mora imati email")
    @Size(min = 3, max = 20)
    private String email;

    @NotBlank(message = "Korisnik mora imati lozinka")
    @Size(min = 3, max = 20)
    private String lozinka;

    private Long adresaId;
}
