package com.beesion.ms.test.maper;

import com.beesion.ms.model.Person;
import com.beesion.ms.test.dto.PersonDto;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Clase dedicada exclusivamente al mapeo entre Person y PersonDto.
 * Justificación: aplicamos SRP, evitando que el servicio o el controlador asuman responsabilidades de transformación.
 */
@ApplicationScoped
public class PersonMapper {

    public PersonDto toDto(Person entity) {
        PersonDto dto = new PersonDto();
        dto.id = entity.getId();
        dto.nombre = entity.getNombre();
        dto.edad = entity.getEdad();
        return dto;
    }

    public Person toEntity(PersonDto dto) {
        Person entity = new Person();
        entity.setId(dto.id);
        entity.setNombre(dto.nombre);
        entity.setEdad(dto.edad);
        return entity;
    }
}
