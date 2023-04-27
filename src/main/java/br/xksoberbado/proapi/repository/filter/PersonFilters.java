package br.xksoberbado.proapi.repository.filter;

import br.xksoberbado.proapi.model.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonFilters {

    private String name;
    private Gender gender;
}
