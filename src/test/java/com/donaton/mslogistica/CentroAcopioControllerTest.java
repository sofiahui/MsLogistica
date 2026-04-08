package com.donaton.mslogistica;

import com.donaton.mslogistica.model.CentroAcopio;
import com.donaton.mslogistica.respository.CentroAcopioRepository;
import com.donaton.mslogistica.service.CentroAcopioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CentroAcopioControllerTest {

    @Autowired
    private CentroAcopioService service;

    @Autowired
    private CentroAcopioRepository repository;

    @BeforeEach
    void limpiar() {
        repository.deleteAll();
    }

    @Test
    void crearCentro_debeGuardarYRetornarConId() {
        CentroAcopio c = service.crear("Centro Norte", "Av. Principal", "RM", 100);
        assertNotNull(c.getId());
        assertEquals("Centro Norte", c.getNombre());
    }

    @Test
    void listarCentros_debeRetornarListaNoNula() {
        service.crear("Centro Sur", "Calle 5", "Valpo", 50);
        assertFalse(service.listar().isEmpty());
    }
}