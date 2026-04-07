package com.donaton.mslogistica.respository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.donaton.mslogistica.model.CentroAcopio;

@Repository
public interface CentroAcopioRepository extends JpaRepository<CentroAcopio, Long> {
    List<CentroAcopio> findByRegion(String region);
    List<CentroAcopio> findByEstado(String estado);
}