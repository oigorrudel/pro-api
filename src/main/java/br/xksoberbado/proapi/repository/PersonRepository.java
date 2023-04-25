package br.xksoberbado.proapi.repository;

import br.xksoberbado.proapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
