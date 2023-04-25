package br.xksoberbado.proapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class PersonResponse {

    private UUID id;
    private String name;
}
