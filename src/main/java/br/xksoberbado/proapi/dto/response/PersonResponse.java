package br.xksoberbado.proapi.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PersonResponse {

    private UUID id;
    private String name;
}
