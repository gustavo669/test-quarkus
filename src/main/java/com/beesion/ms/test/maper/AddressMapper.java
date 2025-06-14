package com.beesion.ms.test.maper;

import com.beesion.ms.model.Address;
import com.beesion.ms.model.Person;
import com.beesion.ms.test.dto.AddressDto;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressMapper {

    public AddressDto toDto(Address entity) {
        AddressDto dto = new AddressDto();
        dto.id = entity.getId();
        dto.calle = entity.getCalle();
        dto.ciudad = entity.getCiudad();
        dto.pais = entity.getPais();
        dto.personId = entity.getPerson() != null ? entity.getPerson().getId() : null;
        return dto;
    }

    public Address toEntity(AddressDto dto, Person person) {
        Address entity = new Address();
        entity.setId(dto.id);
        entity.setCalle(dto.calle);
        entity.setCiudad(dto.ciudad);
        entity.setPais(dto.pais);
        entity.setPerson(person);
        return entity;
    }
}
