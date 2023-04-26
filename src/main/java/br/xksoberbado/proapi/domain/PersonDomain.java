package br.xksoberbado.proapi.domain;

import br.xksoberbado.proapi.model.Gender;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDomain {

    private UUID id;
    private String name;
    private Gender gender;
}
