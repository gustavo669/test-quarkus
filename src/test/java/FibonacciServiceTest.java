import com.beesion.ms.test.service.impl.FibonacciService;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la generación de secuencias de Fibonacci.
 */
public class FibonacciServiceTest {

    FibonacciService service = new FibonacciService();

    /**
     * Caso válido: secuencia Fibonacci desde [0, 1], n = 9
     * Resultado esperado: [0, 1, 1, 2, 3, 5, 8, 13, 21]
     */
    @Test
    public void testFibonacciClassico() {
        int[] firma = {0, 1};
        List<Integer> resultado = service.generarFibonacci(firma, 9);
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21), resultado);
    }

    /**
     * Caso válido: secuencia personalizada desde [2, 3], n = 5
     * Resultado esperado: [2, 3, 5, 8, 13]
     */
    @Test
    public void testFibonacciPersonalizado() {
        int[] firma = {2, 3};
        List<Integer> resultado = service.generarFibonacci(firma, 5);
        assertEquals(List.of(2, 3, 5, 8, 13), resultado);
    }

    /**
     * Caso límite: n = 0 debe devolver lista vacía
     */
    @Test
    public void testFibonacciVacio() {
        int[] firma = {1, 1};
        List<Integer> resultado = service.generarFibonacci(firma, 0);
        assertTrue(resultado.isEmpty());
    }
}
