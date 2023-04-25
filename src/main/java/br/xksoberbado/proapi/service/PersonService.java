package br.xksoberbado.proapi.service;

import br.xksoberbado.proapi.dto.request.CreatePersonRequest;
import br.xksoberbado.proapi.dto.request.UpdatePersonRequest;
import br.xksoberbado.proapi.model.Person;
import br.xksoberbado.proapi.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Person getById(final UUID personId) {
        return repository.findById(personId)
            .orElseThrow();
    }

    public Person create(final CreatePersonRequest request) {
        final var person = Person.of(
            UUID.randomUUID(), request.getName(), request.getGender()
        );

        return repository.save(person);
    }

    public Person update(final UUID personId,
                         final UpdatePersonRequest request) {
        final var person = getById(personId);

        person.setName(request.getName());

        return repository.save(person);
    }
}
