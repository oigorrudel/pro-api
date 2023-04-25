package br.xksoberbado.proapi.controller;

import br.xksoberbado.proapi.dto.request.CreatePersonRequest;
import br.xksoberbado.proapi.dto.request.UpdatePersonRequest;
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
    public PersonResponse create(@RequestBody @Validated CreatePersonRequest request) {
        final var person = service.create(request);

        return PersonResponse.of(person.getId(), person.getName());
    }

    @PutMapping("{personId}")
    public PersonResponse update(@PathVariable UUID personId,
                                 @RequestBody @Validated UpdatePersonRequest request) {
        final var person = service.update(personId, request);

        return PersonResponse.of(person.getId(), person.getName());
    }
}
