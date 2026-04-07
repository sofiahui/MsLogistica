package com.donaton.mslogistica.respository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.donaton.mslogistica.model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    List<Envio> findByEstado(String estado);
    List<Envio> findByCentroAcopioId(Long centroAcopioId);
}