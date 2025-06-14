import com.beesion.ms.model.Person;
import com.beesion.ms.test.dto.PersonDto;

import com.beesion.ms.test.maper.PersonMapper;
import com.beesion.ms.test.repository.PersonRepo;
import com.beesion.ms.test.service.impl.PersonService;
import io.quarkus.test.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


/**
 * Pruebas unitarias para la clase PersonService.
 */
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepo repository;

    @Mock
    private PersonMapper mapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Prueba listar(): Verifica que se devuelvan los DTO correctamente desde la lista de entidades.
     */
    @Test
    public void testListarPersonas() {
        Person persona1 = new Person();
        persona1.setId(1L);
        persona1.setNombre("Juan");
        persona1.setEdad(30);

        Person persona2 = new Person();
        persona2.setId(2L);
        persona2.setNombre("Ana");
        persona2.setEdad(25);

        when(repository.listAll()).thenReturn(List.of(persona1, persona2));
        when(mapper.toDto(persona1)).thenReturn(new PersonDto() {{ id = 1L; nombre = "Juan"; edad = 30; }});
        when(mapper.toDto(persona2)).thenReturn(new PersonDto() {{ id = 2L; nombre = "Ana"; edad = 25; }});

        List<PersonDto> resultado = personService.listar();

        assertEquals(2, resultado.size());
        assertEquals("Juan", resultado.get(0).nombre);
        assertEquals("Ana", resultado.get(1).nombre);
    }

    /**
     * Prueba guardar(): Verifica que se transforme y persista correctamente una persona.
     */
    @Test
    public void testGuardarPersona() {
        PersonDto dto = new PersonDto();
        dto.id = null;
        dto.nombre = "Carlos";
        dto.edad = 40;

        Person entity = new Person();
        entity.setNombre("Carlos");
        entity.setEdad(40);

        when(mapper.toEntity(dto)).thenReturn(entity);
        doNothing().when(repository).persist(entity);
        when(mapper.toDto(entity)).thenReturn(new PersonDto() {{
            id = 10L;
            nombre = "Carlos";
            edad = 40;
        }});

        PersonDto resultado = personService.guardar(dto);

        assertNotNull(resultado);
        assertEquals("Carlos", resultado.nombre);
        assertEquals(40, resultado.edad);
        assertEquals(10L, resultado.id);
    }
}
