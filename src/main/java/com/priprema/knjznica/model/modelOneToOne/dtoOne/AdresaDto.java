package com.priprema.knjznica.model.modelOneToOne.dtoOne;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdresaDto {

    private Long Id;

    @NotBlank(message = "Adresa mora imati ulicu")
    @Size(min = 3, max = 20)
    private String ulica;

    @NotNull(message = "Adresa mora imati broj")
    private Integer broj;

    @NotBlank(message = "Adresa mora imati grad")
    @Size(min = 3, max = 20)
    private String grad;

    @NotNull(message = "Adresa mora imati postanskiBroj")
    private Integer postanskiBroj;
}
