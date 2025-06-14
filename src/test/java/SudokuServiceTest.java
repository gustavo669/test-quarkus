import com.beesion.ms.test.service.impl.SudokuService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la validación de tableros Sudoku.
 */
public class SudokuServiceTest {

    SudokuService service = new SudokuService();

    /**
     * Caso válido: tablero parcial correcto.
     */
    @Test
    public void testTableroValido() {
        String[][] board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        assertTrue(service.esTableroValido(board));
    }

    /**
     * Caso inválido: número repetido en un subcuadro 3x3.
     * Hay dos ochos (8) en la esquina superior izquierda.
     */
    @Test
    public void testSubcuadroInvalido() {
        String[][] board = {
                {"8","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        assertFalse(service.esTableroValido(board));
    }
}
