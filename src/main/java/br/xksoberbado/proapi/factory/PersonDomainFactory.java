package br.xksoberbado.proapi.factory;

import br.xksoberbado.proapi.domain.PersonDomain;
import br.xksoberbado.proapi.dto.request.CreatePersonRequest;
import br.xksoberbado.proapi.dto.request.UpdatePersonRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PersonDomainFactory {

    public PersonDomain toCreate(final CreatePersonRequest request) {
        return PersonDomain.builder()
            .id(UUID.randomUUID())
            .name(request.getName())
            .gender(request.getGender())
            .build();
    }

    public PersonDomain toUpdate(final UUID personId,
                                 final UpdatePersonRequest request) {
        return PersonDomain.builder()
            .id(personId)
            .name(request.getName())
            .build();
    }
}
