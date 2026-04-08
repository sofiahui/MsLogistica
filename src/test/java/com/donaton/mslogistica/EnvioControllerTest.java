package com.donaton.mslogistica;

import com.donaton.mslogistica.model.Envio;
import com.donaton.mslogistica.respository.EnvioRepository;
import com.donaton.mslogistica.service.EnvioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnvioControllerTest {

    @Autowired
    private EnvioService service;

    @Autowired
    private EnvioRepository repository;

    @BeforeEach
    void limpiar() {
        repository.deleteAll();
    }

    @Test
    void crearEnvio_debeGuardarYRetornarConId() {
        Envio e = service.crear("camion", "Santiago", "Valparaiso", 1L);
        assertNotNull(e.getId());
        assertEquals("camion", e.getTipoTransporte());
    }

    @Test
    void listarEnvios_debeRetornarListaNoNula() {
        service.crear("furgon", "Rancagua", "Santiago", 2L);
        assertFalse(service.listar().isEmpty());
    }
}