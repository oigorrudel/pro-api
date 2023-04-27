package br.xksoberbado.proapi.service;

import br.xksoberbado.proapi.domain.PersonDomain;
import br.xksoberbado.proapi.model.Person;
import br.xksoberbado.proapi.repository.PersonRepository;
import br.xksoberbado.proapi.repository.filter.PersonFilters;
import br.xksoberbado.proapi.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
    private final ObjectMapperUtil objectMapperUtil;

    public List<PersonDomain> getAll(final PersonFilters filters) {
        final var people = Optional.ofNullable(filters.getName())
            .map(repository::findAllByName)
            .orElseGet(repository::findAll);

        return objectMapperUtil.mapAll(people, PersonDomain.class);
    }

    public PersonDomain getById(final UUID personId) {
        return repository.findById(personId)
            .map(objectMapperUtil.mapFn(PersonDomain.class))
            .orElseThrow();
    }

    public PersonDomain create(final PersonDomain personDomain) {
        final var person = objectMapperUtil.map(
            personDomain, Person.class
        );

        return objectMapperUtil.map(
            repository.save(person), PersonDomain.class
        );
    }

    public PersonDomain update(final PersonDomain updatePersonDomain) {
        final var personDomain = getById(updatePersonDomain.getId());

        personDomain.setName(updatePersonDomain.getName());

        final var person = repository.save( //@CreationTimestamp
            objectMapperUtil.map(personDomain, Person.class)
        );

        return objectMapperUtil.map(person, PersonDomain.class);
    }
}
