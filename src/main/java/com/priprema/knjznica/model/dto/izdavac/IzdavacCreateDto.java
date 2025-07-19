package com.priprema.knjznica.model.dto.izdavac;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IzdavacCreateDto {
    
    @NotBlank(message = "Izdavac mora imati naziv")
    @Size(min = 3, max = 20)
    private String naziv;

    @NotBlank(message = "Izdavac mora imati autora")
    @Size(min = 3, max = 20)
    private String autor;

}
