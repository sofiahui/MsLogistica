package com.donaton.mslogistica;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.donaton.mslogistica.model.CentroAcopio;
import com.donaton.mslogistica.respository.CentroAcopioRepository;





@SpringBootTest
class CentroAcopioRepositoryTest {

    @Autowired
    private CentroAcopioRepository repository;

    @BeforeEach
    void limpiar() {
        repository.deleteAll();
    }

    @Test
    void findByRegion_debeRetornarCentrosDeLaRegion() {
        CentroAcopio c = new CentroAcopio();
        c.setNombre("Centro RM");
        c.setDireccion("Av. Principal");
        c.setRegion("RM");
        c.setCapacidadMaxima(100);
        c.setCapacidadActual(0);
        c.setEstado("activo");
        repository.save(c);

        List<CentroAcopio> resultado = repository.findByRegion("RM");
        assertFalse(resultado.isEmpty());
        assertEquals("RM", resultado.get(0).getRegion());
    }

    @Test
    void findByEstado_debeRetornarCentrosActivos() {
        CentroAcopio c = new CentroAcopio();
        c.setNombre("Centro Activo");
        c.setDireccion("Calle 1");
        c.setRegion("RM");
        c.setCapacidadMaxima(50);
        c.setCapacidadActual(0);
        c.setEstado("activo");
        repository.save(c);

        List<CentroAcopio> resultado = repository.findByEstado("activo");
        assertFalse(resultado.isEmpty());
    }
}