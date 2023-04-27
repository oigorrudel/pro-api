package br.xksoberbado.proapi.dto.params;

import br.xksoberbado.proapi.model.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonParams { //PersonRequestParams, PersonQueryParams

    private String name;
    private Gender gender; //+ 3 request params
}
