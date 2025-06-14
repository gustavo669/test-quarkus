package com.beesion.ms.test.service.impl;


import com.beesion.ms.model.Address;
import com.beesion.ms.model.Person;
import com.beesion.ms.test.dto.AddressDto;

import com.beesion.ms.test.maper.AddressMapper;
import com.beesion.ms.test.repository.AddressRepository;

import com.beesion.ms.test.repository.PersonRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AddressService {

    @Inject
    AddressRepository repository;

    @Inject
    PersonRepo personRepository;

    @Inject
    AddressMapper mapper;

    public AddressDto guardar(AddressDto dto) {
        Person person = personRepository.findById(dto.personId);
        if (person == null) throw new IllegalArgumentException("Persona no encontrada");

        Address entity = mapper.toEntity(dto, person);
        repository.persist(entity);
        return mapper.toDto(entity);
    }

    public List<AddressDto> listar() {
        return repository.listAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<AddressDto> listarPorPersona(Long personId) {
        return repository.findByPersonId(personId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public AddressDto actualizar(Long id, AddressDto dto) {
        Address existente = repository.findById(id);
        if (existente == null) {
            throw new NotFoundException("Dirección no encontrada con id: " + id);
        }

        Person person = personRepository.findById(dto.personId);
        if (person == null) {
            throw new IllegalArgumentException("Persona no encontrada con id: " + dto.personId);
        }

        existente.setCalle(dto.calle);
        existente.setCiudad(dto.ciudad);
        existente.setPais(dto.pais);
        existente.setPerson(person);

        return mapper.toDto(existente);
    }

    public void eliminar(Long id) {
        Address address = repository.findById(id);
        if (address == null) {
            throw new NotFoundException("Dirección no encontrada con id: " + id);
        }
        repository.delete(address);
    }

}
