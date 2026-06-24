package com.donaton.mslogistica.respository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.donaton.mslogistica.model.Envio;


public interface EnvioRepository extends JpaRepository<Envio, Long> {
    List<Envio> findByEstado(String estado);
    List<Envio> findByCentroAcopioId(Long centroAcopioId);
}