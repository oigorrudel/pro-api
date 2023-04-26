package br.xksoberbado.proapi.service;

import br.xksoberbado.proapi.domain.PersonDomain;
import br.xksoberbado.proapi.model.Person;
import br.xksoberbado.proapi.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<PersonDomain> getAll() {
        return repository.findAll()
            .stream()
            .map(mapPersonToDomain())
            .toList();
    }

    public PersonDomain getById(final UUID personId) {
        return repository.findById(personId)
            .map(mapPersonToDomain())
            .orElseThrow();
    }

    public PersonDomain create(final PersonDomain personDomain) {
        final var person = mapDomainToPerson()
            .apply(personDomain);

        return mapPersonToDomain()
            .apply(repository.save(person));
    }

    public PersonDomain update(final PersonDomain updatePersonDomain) {
        final var personDomain = getById(updatePersonDomain.getId());

        personDomain.setName(updatePersonDomain.getName());

        final var person = repository.save( //@CreationTimestamp
            mapDomainToPerson()
                .apply(personDomain)
        );

        return mapPersonToDomain()
            .apply(person);
    }

    private Function<Person, PersonDomain> mapPersonToDomain() {
        return person -> PersonDomain.builder()
            .id(person.getId())
            .name(person.getName())
            .gender(person.getGender())
            .build();
    }

    private Function<PersonDomain, Person> mapDomainToPerson() {
        return person -> Person.builder()
            .id(person.getId())
            .name(person.getName())
            .gender(person.getGender())
            .build();
    }
}
