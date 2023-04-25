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
        final var joao = Person.of(UUID.randomUUID(), "João", Gender.MALE);
        final var maria = Person.of(UUID.randomUUID(), "Maria", Gender.FEMALE);

        log.info("João: {}", joao);
        log.info("Maria: {}", maria);

        personRepository.saveAll(List.of(joao, maria));
    }
}
