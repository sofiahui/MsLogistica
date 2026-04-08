package com.donaton.mslogistica;


import static org.junit.jupiter.api.Assertions.assertFalse;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.donaton.mslogistica.model.Envio;
import com.donaton.mslogistica.respository.EnvioRepository;





@SpringBootTest
class EnvioRepositoryTest {

    @Autowired
    private EnvioRepository repository;

    @BeforeEach
    void limpiar() {
        repository.deleteAll();
    }

    @Test
    void findByEstado_debeRetornarEnviosPendientes() {
        Envio e = new Envio();
        e.setTipoTransporte("camion");
        e.setOrigen("Santiago");
        e.setDestino("Valparaiso");
        e.setFechaEnvio(LocalDate.now());
        e.setEstado("pendiente");
        e.setCentroAcopioId(1L);
        repository.save(e);

        List<Envio> resultado = repository.findByEstado("pendiente");
        assertFalse(resultado.isEmpty());
    }

    @Test
    void findByCentroAcopioId_debeRetornarEnviosDelCentro() {
        Envio e = new Envio();
        e.setTipoTransporte("furgon");
        e.setOrigen("Rancagua");
        e.setDestino("Santiago");
        e.setFechaEnvio(LocalDate.now());
        e.setEstado("en_camino");
        e.setCentroAcopioId(5L);
        repository.save(e);

        List<Envio> resultado = repository.findByCentroAcopioId(5L);
        assertFalse(resultado.isEmpty());
    }
}