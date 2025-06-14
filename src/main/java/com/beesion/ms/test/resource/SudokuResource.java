package com.beesion.ms.test.resource;

import com.beesion.ms.model.SudokuRequest;
import com.beesion.ms.test.service.impl.SudokuService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Recurso REST para validar tableros de Sudoku.
 */
@Path("/sudoku")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SudokuResource {

    @Inject
    SudokuService sudokuService;

    @POST
    @Path("/validar")
    public Response validarSudoku(SudokuRequest request) {
        boolean esValido = sudokuService.esTableroValido(request.board);
        return Response.ok().entity("{\"valido\":" + esValido + "}").build();
    }
}
