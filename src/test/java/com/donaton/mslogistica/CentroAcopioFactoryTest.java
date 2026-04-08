package com.donaton.mslogistica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.donaton.mslogistica.model.CentroAcopio;
import com.donaton.mslogistica.factory.CentroAcopioFactory;





class CentroAcopioFactoryTest {

    private CentroAcopioFactory factory = new CentroAcopioFactory();

    @Test
    void crear_debeAsignarEstadoActivoPorDefecto() {
        CentroAcopio c = factory.crear("Centro Norte", "Av. Principal 123", "RM", 100);
        assertEquals("activo", c.getEstado());
    }

    @Test
    void crear_debeAsignarCapacidadActualEnCero() {
        CentroAcopio c = factory.crear("Centro Sur", "Calle 5", "Valpo", 50);
        assertEquals(0, c.getCapacidadActual());
    }

    @Test
    void crear_debeAsignarCamposCorrectamente() {
        CentroAcopio c = factory.crear("Centro Este", "Ruta 68", "RM", 200);
        assertEquals("Centro Este", c.getNombre());
        assertEquals("RM", c.getRegion());
        assertEquals(200, c.getCapacidadMaxima());
    }
}