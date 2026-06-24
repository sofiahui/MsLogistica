package com.donaton.mslogistica;

import com.donaton.mslogistica.controller.EnvioController;
import com.donaton.mslogistica.model.Envio;
import com.donaton.mslogistica.respository.EnvioRepository;
import com.donaton.mslogistica.service.EnvioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
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

    @Test
    void listarController_debeRetornarLista() {

        EnvioController controller =
                new EnvioController(service);

        service.crear(
                "camion",
                "Santiago",
                "Valparaiso",
                1L
        );

        List<Envio> lista = controller.listar();

        assertFalse(lista.isEmpty());

    }

    @Test
    void crearController_debeGuardarEnvio() {

        EnvioController controller =
                new EnvioController(service);

        Envio e = new Envio();

        e.setTipoTransporte("furgon");
        e.setOrigen("Rancagua");
        e.setDestino("Santiago");
        e.setCentroAcopioId(2L);

        Envio creado = controller.crear(e);

        assertNotNull(creado.getId());

        assertEquals(
                "furgon",
                creado.getTipoTransporte()
        );

    }

    @Test
    void obtenerController_debeRetornarEnvio() {

        EnvioController controller =
                new EnvioController(service);

        Envio creado = service.crear(
                "camion",
                "Santiago",
                "Valparaiso",
                1L
        );

        ResponseEntity<Envio> response =
                controller.obtener(
                        creado.getId()
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

    }

    @Test
    void obtenerController_debeRetornar404() {

        EnvioController controller =
                new EnvioController(service);

        ResponseEntity<Envio> response =
                controller.obtener(999L);

        assertEquals(
                404,
                response.getStatusCode().value()
        );

    }
}