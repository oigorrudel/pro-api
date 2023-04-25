package br.xksoberbado.proapi.controller;

import br.xksoberbado.proapi.dto.request.PersonRequest;
import br.xksoberbado.proapi.dto.response.PersonResponse;
import br.xksoberbado.proapi.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("{personId}")
    public PersonResponse get(@PathVariable UUID personId) {
        final var person = service.getById(personId);

        return PersonResponse.of(person.getId(), person.getName());
    }

    @PostMapping
    public PersonResponse create(@RequestBody @Validated PersonRequest request) {
        final var person = service.create(request);

        return PersonResponse.of(person.getId(), person.getName());
    }
}
