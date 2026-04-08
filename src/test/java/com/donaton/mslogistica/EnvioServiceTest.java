package com.donaton.mslogistica;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.donaton.mslogistica.model.Envio;
import com.donaton.mslogistica.respository.EnvioRepository;
import com.donaton.mslogistica.service.EnvioService;


@SpringBootTest
class EnvioServiceTest {

    @Autowired
    private EnvioService service;

    @Autowired
    private EnvioRepository repository;

    @BeforeEach
    void limpiar() {
        repository.deleteAll();
    }

    @Test
    void crear_debeGuardarEnvioCorrectamente() {
        Envio e = service.crear("camion", "Santiago", "Valparaiso", 1L);
        assertNotNull(e.getId());
        assertEquals("pendiente", e.getEstado());
    }

    @Test
    void listar_debeRetornarEnvios() {
        service.crear("furgon", "Rancagua", "Santiago", 2L);
        List<Envio> lista = service.listar();
        assertFalse(lista.isEmpty());
    }
}