package com.beesion.ms.test.service;

import com.beesion.ms.test.dto.PersonDto;
import java.util.List;

public interface IPersonService {
	List<PersonDto> listar();
	PersonDto guardar(PersonDto dto);
}
