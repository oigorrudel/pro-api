package br.xksoberbado.proapi.controller;

import br.xksoberbado.proapi.model.Person;
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
    private Person get(@PathVariable UUID personId) {
        return service.getById(personId);
    }
}
