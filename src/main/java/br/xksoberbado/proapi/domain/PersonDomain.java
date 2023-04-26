package br.xksoberbado.proapi.domain;

import br.xksoberbado.proapi.model.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class PersonDomain {

    private UUID id;
    private String name;
    private Gender gender;
}
