package br.xksoberbado.proapi.controller;

import br.xksoberbado.proapi.dto.response.PersonResponse;
import br.xksoberbado.proapi.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("{personId}")
    private PersonResponse get(@PathVariable UUID personId) {
        final var person = service.getById(personId);

        return PersonResponse.of(person.getId(), person.getName());
    }
}
