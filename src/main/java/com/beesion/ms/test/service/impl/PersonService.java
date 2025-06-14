package com.beesion.ms.test.service.impl;


import com.beesion.ms.model.Person;
import com.beesion.ms.test.dto.PersonDto;


import com.beesion.ms.test.maper.PersonMapper;
import com.beesion.ms.test.repository.PersonRepo;
import com.beesion.ms.test.service.IPersonService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que aplica SRP, se encarga exclusivamente de la lógica de negocio.
 */
@ApplicationScoped
public class PersonService implements IPersonService {

	@Inject
	PersonRepo repository;

	@Inject
	PersonMapper mapper;

	@Override
	public List<PersonDto> listar() {
		return repository.listAll()
				.stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public PersonDto guardar(PersonDto dto) {
		Person entity = mapper.toEntity(dto);
		repository.persist(entity);
		return mapper.toDto(entity);
	}
}
