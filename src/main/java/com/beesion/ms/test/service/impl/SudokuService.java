package com.beesion.ms.test.service.impl;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashSet;

/**
 * Servicio que contiene la lógica para validar un tablero de Sudoku parcialmente lleno.
 */
@ApplicationScoped
public class SudokuService {

    /**
     * Valida un tablero de Sudoku de acuerdo a las reglas estándar.
     *
     * @param board tablero 9x9 donde las celdas vacías se representan con "." o null.
     * @return true si el tablero es válido, false si hay alguna violación.
     */
    public boolean esTableroValido(String[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<String> fila = new HashSet<>();
            HashSet<String> columna = new HashSet<>();
            HashSet<String> cuadro = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Fila
                String valFila = board[i][j];
                if (valFila != null && !valFila.equals(".")) {
                    if (!fila.add(valFila)) return false;
                }

                // Columna
                String valCol = board[j][i];
                if (valCol != null && !valCol.equals(".")) {
                    if (!columna.add(valCol)) return false;
                }

                // Subcuadro 3x3
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                String valBox = board[rowIndex + j / 3][colIndex + j % 3];
                if (valBox != null && !valBox.equals(".")) {
                    if (!cuadro.add(valBox)) return false;
                }
            }
        }
        return true;
    }
}
