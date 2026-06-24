package com.donaton.mslogistica.respository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.donaton.mslogistica.model.CentroAcopio;


public interface CentroAcopioRepository extends JpaRepository<CentroAcopio, Long> {
    List<CentroAcopio> findByRegion(String region);
    List<CentroAcopio> findByEstado(String estado);
}