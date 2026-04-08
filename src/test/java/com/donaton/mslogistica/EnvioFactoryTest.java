package com.donaton.mslogistica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.donaton.mslogistica.model.Envio;
import com.donaton.mslogistica.factory.EnvioFactory;

class EnvioFactoryTest {

    private EnvioFactory factory = new EnvioFactory();

    @Test
    void crear_debeAsignarEstadoPendientePorDefecto() {
        Envio e = factory.crear("camion", "Santiago", "Valparaiso", 1L);
        assertEquals("pendiente", e.getEstado());
    }

    @Test
    void crear_debeAsignarFechaDeHoy() {
        Envio e = factory.crear("furgon", "Rancagua", "Santiago", 2L);
        assertEquals(LocalDate.now(), e.getFechaEnvio());
    }

    @Test
    void crear_debeAsignarCamposCorrectamente() {
        Envio e = factory.crear("moto", "Santiago", "Maipu", 3L);
        assertEquals("moto", e.getTipoTransporte());
        assertEquals("Santiago", e.getOrigen());
        assertEquals("Maipu", e.getDestino());
        assertEquals(3L, e.getCentroAcopioId());
    }
}