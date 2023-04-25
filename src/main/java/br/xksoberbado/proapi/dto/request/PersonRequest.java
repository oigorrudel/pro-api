package br.xksoberbado.proapi.dto.request;

import br.xksoberbado.proapi.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest { //PersonRequestDTO, PersonBody, CreatePersonRequest

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Gender gender;
}
