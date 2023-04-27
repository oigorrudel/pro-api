package br.xksoberbado.proapi.runner;

import br.xksoberbado.proapi.model.Gender;
import br.xksoberbado.proapi.model.Person;
import br.xksoberbado.proapi.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestRunner implements ApplicationRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        final var joao = Person.builder()
            .id(UUID.fromString("80fbba2b-3797-46f0-9e50-03e9862461c0"))
            .name("João")
            .gender(Gender.MALE)
            .build();

        final var maria = Person.builder()
            .id(UUID.fromString("9b6f770e-6713-4e69-bcd8-2458bead856d"))
            .name("Maria")
            .gender(Gender.FEMALE)
            .build();

        personRepository.saveAll(List.of(joao, maria));
    }
}
