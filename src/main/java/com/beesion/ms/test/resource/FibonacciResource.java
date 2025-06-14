package com.beesion.ms.test.resource;

import com.beesion.ms.model.FibonacciRequest;
import com.beesion.ms.test.service.impl.FibonacciService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * Recurso REST para generar secuencias de Fibonacci.
 */
@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FibonacciResource {

    @Inject
    FibonacciService service;

    @POST
    @Path("/generar")
    public Response generarFibonacci(FibonacciRequest request) {
        List<Integer> secuencia = service.generarFibonacci(request.firma, request.n);
        return Response.ok(secuencia).build();
    }
}
