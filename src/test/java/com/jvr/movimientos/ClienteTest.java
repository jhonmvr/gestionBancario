package com.jvr.movimientos;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.persistence.entity.Persona;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void testClienteSettersAndGetters() {
        Cliente cliente = new Cliente();
        cliente.setId(1);


        Persona persona = new Persona();
        persona.setNombre("John Doe");
        persona.setIdentificacion("1721395125");
        persona.setDireccion("1234 Elm Street");
        persona.setEdad(32);
        persona.setTelefono("555-1234");
        persona.setGenero("Masculino");


        cliente.setIdentificacion(persona);
        cliente.setContrasena("contrasena");
        cliente.setEstado(true);

        assertEquals(1, cliente.getId());
        assertEquals("John Doe", cliente.getIdentificacion().getNombre());
        assertEquals("1721395125", cliente.getIdentificacion().getIdentificacion());
        assertEquals("1234 Elm Street", cliente.getIdentificacion().getDireccion());
        assertEquals(32, cliente.getIdentificacion().getEdad());
        assertEquals("555-1234", cliente.getIdentificacion().getTelefono());
        assertEquals("Masculino", cliente.getIdentificacion().getGenero());
        assertEquals("contrasena", cliente.getContrasena());
        assertEquals(Boolean.TRUE, cliente.getEstado());
    }
}
