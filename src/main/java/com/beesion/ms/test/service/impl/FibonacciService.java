package com.beesion.ms.test.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de generar secuencias de Fibonacci personalizadas.
 */
@ApplicationScoped
public class FibonacciService {

    /**
     * Genera una secuencia de Fibonacci basada en una firma inicial y una longitud deseada.
     *
     * @param firma arreglo de 2 elementos con los valores iniciales
     * @param n     número total de elementos a devolver
     * @return lista de enteros representando la secuencia
     */
    public List<Integer> generarFibonacci(int[] firma, int n) {
        List<Integer> resultado = new ArrayList<>();
        if (n == 0) return resultado;

        for (int i = 0; i < n; i++) {
            if (i < 2) {
                resultado.add(firma[i]);
            } else {
                int siguiente = resultado.get(i - 1) + resultado.get(i - 2);
                resultado.add(siguiente);
            }
        }
        return resultado;
    }
}
