package com.donaton.mslogistica;

import com.donaton.mslogistica.controller.CentroAcopioController;
import com.donaton.mslogistica.model.CentroAcopio;
import com.donaton.mslogistica.respository.CentroAcopioRepository;
import com.donaton.mslogistica.service.CentroAcopioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
    @Test
    void listarController_debeRetornarLista() {

        CentroAcopioController controller =
                new CentroAcopioController(service);

        service.crear(
                "Centro Norte",
                "Av Principal",
                "RM",
                100
        );

        List<CentroAcopio> lista =
                controller.listar();

        assertFalse(lista.isEmpty());

        }
     
     @Test
        void crearController_debeGuardarCentro() {

            CentroAcopioController controller =
                    new CentroAcopioController(service);

            CentroAcopio c = new CentroAcopio();

            c.setNombre("Centro Sur");
            c.setDireccion("Calle 5");
            c.setRegion("Valpo");
            c.setCapacidadMaxima(50);

            CentroAcopio creado =
                    controller.crear(c);

            assertNotNull(creado.getId());

            assertEquals(
                    "Centro Sur",
                    creado.getNombre()
            );

        }   

     @Test
        void obtenerController_debeRetornarCentro() {

            CentroAcopioController controller =
                    new CentroAcopioController(service);

            CentroAcopio creado =
                    service.crear(
                            "Centro Norte",
                            "Av Principal",
                            "RM",
                            100
                    );

            ResponseEntity<CentroAcopio> response =
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

        CentroAcopioController controller =
                new CentroAcopioController(service);

        ResponseEntity<CentroAcopio> response =
                controller.obtener(999L);

        assertEquals(
                404,
                response.getStatusCode().value()
        );

    }
}