package com.beesion.ms.test.resource;

import com.beesion.ms.test.dto.AddressDto;
import com.beesion.ms.test.dto.PersonDto;

import com.beesion.ms.test.service.IPersonService;

import com.beesion.ms.test.service.impl.AddressService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * Recurso REST. Aplica SRP al delegar toda lógica a los servicios y mapeadores.
 */
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaResource {

	@Inject
	IPersonService service;

	@Inject
	AddressService addressService;

	@GET
	public List<PersonDto> listar() {
		return service.listar();
	}

	@POST
	public Response guardar(PersonDto dto) {
		PersonDto guardado = service.guardar(dto);
		return Response.status(Response.Status.CREATED).entity(guardado).build();
	}

	/**
	 * Obtiene las direcciones asociadas a una persona por su ID.
	 * @param id Identificador de la persona.
	 * @return Lista de direcciones.
	 */
	@GET
	@Path("/{id}/addresses")
	public List<AddressDto> obtenerDireccionesPorPersona(@PathParam("id") Long id) {
		return addressService.listarPorPersona(id);
	}
}

