package com.donaton.mslogistica;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.donaton.mslogistica.model.CentroAcopio;
import com.donaton.mslogistica.respository.CentroAcopioRepository;
import com.donaton.mslogistica.service.CentroAcopioService;




@SpringBootTest
class CentroAcopioServiceTest {

    @Autowired
    private CentroAcopioService service;

    @Autowired
    private CentroAcopioRepository repository;

    @BeforeEach
    void limpiar() {
        repository.deleteAll();
    }

    @Test
    void crear_debeGuardarCentroCorrectamente() {
        CentroAcopio c = service.crear("Centro Test", "Direccion 1", "RM", 100);
        assertNotNull(c.getId());
        assertEquals("Centro Test", c.getNombre());
    }

    @Test
    void listar_debeRetornarCentros() {
        service.crear("Centro A", "Dir A", "RM", 50);
        List<CentroAcopio> lista = service.listar();
        assertFalse(lista.isEmpty());
    }
}
