package br.xksoberbado.proapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@Entity
@ToString
public class Person {

    @Id
    private UUID id;

    private String name;

//    @JsonIgnore //dto / controller
//    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)// totalmente compativel
    private Gender gender;
}
