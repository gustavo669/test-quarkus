package com.beesion.ms.test.resource;

import com.beesion.ms.test.dto.AddressDto;


import com.beesion.ms.test.service.impl.AddressService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    AddressService service;

    @POST
    public Response crear(AddressDto dto) {
        return Response.status(Response.Status.CREATED).entity(service.guardar(dto)).build();
    }

    @GET
    public List<AddressDto> listar() {
        return service.listar();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Long id, AddressDto dto) {
        AddressDto actualizado = service.actualizar(id, dto);
        return Response.ok(actualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        service.eliminar(id);
        return Response.noContent().build();
    }

}
